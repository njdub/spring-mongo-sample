package com.njdub.springmongosample.service.impl;

import com.njdub.springmongosample.domain.Manager;
import com.njdub.springmongosample.model.NewManagerModel;
import com.njdub.springmongosample.repository.ManagerRepository;
import com.njdub.springmongosample.service.ManagerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
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
    public List<Manager> getAll() {
        return managerRepository.findAll();
    }
}
