package ru.database.springmasterdb.services;


import ru.database.springmasterdb.dto.ChatLogDTO;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import java.util.List;

public interface WorkOrderService {

    void createWorkOrder(WorkOrderDTO workOrderDTO);
    void updateWorkOrders(WorkOrderDTO workOrderDTO);
    void updateChatLogInWorkOrders(ChatLogDTO chatLogDTO);

    WorkOrderDtoPresent getByNum(Integer id);

    List<WorkOrderDtoPresent> findAllWorkOrders();
    List<WorkOrderDtoPresent> findAllWorkOrdersIsNeedCall(Boolean isNeedCall);
    List<WorkOrderDtoPresent> findAllByIsDone(Boolean isDone);
    List<WorkOrderDtoPresent> findAllWorkOrdersCreatedAt();
    List<WorkOrderDtoPresent> findAllByEngineerAndiAndIsAccepted(Integer id, Boolean isAccepted);

}
