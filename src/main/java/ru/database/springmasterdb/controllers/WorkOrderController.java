package ru.database.springmasterdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.services.impl.WorkOrderService;
import ru.database.springmasterdb.store.entities.WorkOrder;

@RestController
@RequestMapping("/workorder")
public class WorkOrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final WorkOrderService workOrderService;

    @Autowired
    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @GetMapping
    public String hello(){
        return "Hello";
    }

    @GetMapping("id")
    public String getOne(@PathVariable("id") WorkOrder workOrder){
return "vhnghn";
    }

    @PostMapping
    public void createWorkOrder(@RequestBody WorkOrder workOrder){
        workOrderService.createWorkOrder(workOrder);
        log.info("workorder save controller");
    }
}
