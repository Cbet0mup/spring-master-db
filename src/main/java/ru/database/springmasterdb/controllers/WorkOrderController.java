package ru.database.springmasterdb.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dao.WorkOrderDTO;
import ru.database.springmasterdb.exceptions.EngineerNotFoundException;
import ru.database.springmasterdb.services.impl.WorkOrderService;
import ru.database.springmasterdb.store.entities.WorkOrder;

import javax.validation.Valid;

@RestController
@RequestMapping("/workorder")
public class WorkOrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final WorkOrderService workOrderService;


    @Autowired
    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;

    }

    @PostMapping
    public String createWorkOrder(@Valid @RequestBody WorkOrderDTO workOrderDTO) throws EngineerNotFoundException {
        workOrderService.createWorkOrder(workOrderDTO);
        return "workOrderDTO   created";
    }
}
