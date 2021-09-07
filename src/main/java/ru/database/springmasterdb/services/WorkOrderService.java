package ru.database.springmasterdb.services;

import org.springframework.data.jpa.repository.Query;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.exceptions.EngineerNotFoundException;

import java.util.List;

public interface WorkOrderService {

    void createWorkOrder(WorkOrderDTO workOrderDTO) throws EngineerNotFoundException;

    WorkOrderDtoPresent getByNum(Integer id);

    List<WorkOrderDtoPresent> findAll();
}
