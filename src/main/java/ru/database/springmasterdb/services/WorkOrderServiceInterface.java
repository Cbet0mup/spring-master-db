package ru.database.springmasterdb.services;

import ru.database.springmasterdb.store.entities.WorkOrder;

public interface WorkOrderServiceInterface {

    void createWorkOrder(WorkOrder workOrder);

    void findById();
}
