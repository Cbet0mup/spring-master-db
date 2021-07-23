package ru.database.springmasterdb.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.database.springmasterdb.services.WorkOrderServiceInterface;
import ru.database.springmasterdb.store.entities.WorkOrder;
import ru.database.springmasterdb.store.repositories.WorkOrderRepo;

import java.time.Instant;

@Service
public class WorkOrderService implements WorkOrderServiceInterface {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WorkOrderRepo workOrderRepo;

    @Autowired
    public WorkOrderService(WorkOrderRepo workOrderRepo) {
        this.workOrderRepo = workOrderRepo;
    }

    @Override
    public void createWorkOrder(WorkOrder workOrder) {

    workOrder.setCreatedAt(Instant.now());
    workOrderRepo.save(workOrder);

    log.info("заказ-наряд создан", Instant.now());
    }

    @Override
    public void findById() {

    }
}
