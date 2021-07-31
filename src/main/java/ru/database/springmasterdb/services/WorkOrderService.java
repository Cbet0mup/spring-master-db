package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.exceptions.EngineerNotFoundException;

public interface WorkOrderService {

    void createWorkOrder(WorkOrderDTO workOrderDTO) throws EngineerNotFoundException;

    WorkOrderDtoPresent getByNum(Integer id);
}
