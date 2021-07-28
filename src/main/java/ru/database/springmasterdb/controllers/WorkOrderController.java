package ru.database.springmasterdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.services.WorkOrderServiceImpl;;

@RestController
@RequestMapping("/workorder")
public class WorkOrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final WorkOrderServiceImpl workOrderServiceImpl;


    @Autowired
    public WorkOrderController(WorkOrderServiceImpl workOrderServiceImpl) {
        this.workOrderServiceImpl = workOrderServiceImpl;

    }

    @PostMapping
    public String createWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
        log.info("Принята сущность: " + workOrderDTO.toString());
        workOrderServiceImpl.createWorkOrder(workOrderDTO);
        return "workOrderDTO   created";
    }
}
