package com.njdub.springmongosample.service.impl;

import com.njdub.springmongosample.controller.exception.EntityNotFoundException;
import com.njdub.springmongosample.domain.Manager;
import com.njdub.springmongosample.domain.ManagerWithStatistic;
import com.njdub.springmongosample.domain.TicketStatus;
import com.njdub.springmongosample.model.NewManagerModel;
import com.njdub.springmongosample.repository.ManagerRepository;
import com.njdub.springmongosample.service.ManagerService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.List;

@Component
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final MongoTemplate mongoTemplate;

    public ManagerServiceImpl(ManagerRepository managerRepository,
                              MongoTemplate mongoTemplate) {
        this.managerRepository = managerRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Manager saveNew(NewManagerModel managerModel) {
        Manager manager = new Manager();
        manager.setEmail(managerModel.getEmail());
        manager.setFirstName(managerModel.getFirstName());
        manager.setLastName(managerModel.getLastName());
        return managerRepository.save(manager);
    }

    @Override
    public Manager get(BigInteger id) {
        return managerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Manager not found"));
    }

    @Override
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }

    @Override
    public List<ManagerWithStatistic> getStatistic() {
        // TODO: Create constants for these field names strings
        MatchOperation filterForInProgress = Aggregation.match(new Criteria("status").is(TicketStatus.IN_PROGRESS.name()));
        GroupOperation groupByManagerId = Aggregation.group("managerId").count().as("activeTicketsCount");
        LookupOperation lookupManagerData = Aggregation.lookup("managers", "_id", "_id", "manager");
        SortOperation sortByTicketsCount = Aggregation.sort(Sort.by(Sort.Direction.ASC, "activeTicketsCount"));

        Aggregation aggregation = Aggregation.newAggregation(filterForInProgress, groupByManagerId, sortByTicketsCount, lookupManagerData);
        return mongoTemplate.aggregate(aggregation, "tickets", ManagerWithStatistic.class).getMappedResults();
    }
}
