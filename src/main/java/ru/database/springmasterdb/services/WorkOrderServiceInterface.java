package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dao.WorkOrderDTO;
import ru.database.springmasterdb.exceptions.EngineerNotFoundException;

public interface WorkOrderServiceInterface {

    void createWorkOrder(WorkOrderDTO workOrderDTO) throws EngineerNotFoundException;

    void findById();
}
