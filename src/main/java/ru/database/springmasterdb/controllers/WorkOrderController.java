package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.database.springmasterdb.store.entities.WorkOrder;
import ru.database.springmasterdb.store.repositories.WorkOrderRepo;

@RestController
@RequestMapping("workorder")
public class WorkOrderController {

    private final WorkOrderRepo workOrderRepo;

    @Autowired
    public WorkOrderController(WorkOrderRepo workOrderRepo) {
        this.workOrderRepo = workOrderRepo;
    }

    @GetMapping("id")
    public String getOne(@PathVariable("id") WorkOrder workOrder){
return "vhnghn";
    }
}
