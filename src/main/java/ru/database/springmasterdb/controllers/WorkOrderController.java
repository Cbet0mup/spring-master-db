package ru.database.springmasterdb.controllers;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dao.WorkOrderDTO;
import ru.database.springmasterdb.services.impl.WorkOrderService;
import ru.database.springmasterdb.store.entities.WorkOrder;

import javax.validation.Valid;

@RestController
@RequestMapping("/workorder")
public class WorkOrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final WorkOrderService workOrderService;
    private final ObjectMapper mapper = new ObjectMapper();


    @Autowired
    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;

    }

    @PostMapping
    public WorkOrderDTO createWorkOrder(@PathVariable Long engineerId,
                                  Long manufacturerId,
                                  Long productId,
                                  Long receiverId,
                                  Long serviceId,
                                  Long statusId,
                                  @Valid @RequestBody WorkOrderDTO workOrderDTO) {
        try {

            log.info("workorder save controller");
        } catch (Exception e) {
            e.printStackTrace();
            return workOrderDTO;
        }

        return workOrderDTO;
    }
}
