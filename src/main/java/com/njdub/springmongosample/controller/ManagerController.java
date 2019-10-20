package com.njdub.springmongosample.controller;

import com.njdub.springmongosample.domain.Manager;
import com.njdub.springmongosample.domain.ManagerWithStatistic;
import com.njdub.springmongosample.model.NewManagerModel;
import com.njdub.springmongosample.service.ManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ManagerController {

    private final ManagerService managerService;

    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @GetMapping("/api/manager")
    public ResponseEntity<List<Manager>> getManagers() {
        return ResponseEntity.ok(managerService.getAll());
    }

    @GetMapping("/api/manager/statistic")
    public ResponseEntity<List<ManagerWithStatistic>> getManagersStatistic() {
        return ResponseEntity.ok(managerService.getStatistic());
    }

    @PostMapping("/api/manager")
    public ResponseEntity<Manager> postNewTicket(@RequestBody @Valid NewManagerModel managerModel) {
        Manager manager = managerService.saveNew(managerModel);
        return ResponseEntity.ok(manager);
    }

}
