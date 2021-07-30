package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDTOpresent;
import ru.database.springmasterdb.exceptions.EngineerNotFoundException;

public interface WorkOrderService {

    void createWorkOrder(WorkOrderDTO workOrderDTO) throws EngineerNotFoundException;

    WorkOrderDTOpresent getByNum(Integer id);
}
