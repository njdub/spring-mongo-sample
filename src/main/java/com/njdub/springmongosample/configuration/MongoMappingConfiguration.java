package com.njdub.springmongosample.configuration;

import com.njdub.springmongosample.domain.Manager;
import com.njdub.springmongosample.domain.Ticket;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.IndexResolver;
import org.springframework.data.mongodb.core.index.MongoPersistentEntityIndexResolver;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoMappingConfiguration {

    private final MongoMappingContext mongoMappingContext;
    private final MongoTemplate mongoTemplate;

    public MongoMappingConfiguration(MongoMappingContext mongoMappingContext, MongoTemplate mongoTemplate) {
        this.mongoMappingContext = mongoMappingContext;
        this.mongoTemplate = mongoTemplate;
    }

    /**
     * Automatic index creation will be disabled by default as of Spring Data MongoDB 3.x.
     * This code recommended by spring-data-mongodb authors to control index creation
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initIndicesAfterStartup() {
        IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
        resolver.resolveIndexFor(Manager.class).forEach(mongoTemplate.indexOps(Manager.class)::ensureIndex);
        resolver.resolveIndexFor(Ticket.class).forEach(mongoTemplate.indexOps(Ticket.class)::ensureIndex);
    }

}
