package com.njdub.springmongosample.service;

import com.njdub.springmongosample.domain.Manager;
import com.njdub.springmongosample.domain.Ticket;
import com.njdub.springmongosample.model.NewManagerModel;

import java.util.List;

public interface ManagerService {
    Manager saveNew(NewManagerModel managerModel);

    List<Manager> getAll();
}
