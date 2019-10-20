package com.njdub.springmongosample.service;

import com.njdub.springmongosample.domain.Manager;
import com.njdub.springmongosample.domain.ManagerWithStatistic;
import com.njdub.springmongosample.model.NewManagerModel;

import java.math.BigInteger;
import java.util.List;

public interface ManagerService {
    Manager saveNew(NewManagerModel managerModel);

    Manager get(BigInteger id);

    List<Manager> getAll();

    List<ManagerWithStatistic> getStatistic();
}
