package ru.database.springmasterdb.services;


import ru.database.springmasterdb.dto.*;

import java.util.List;

public interface WorkOrderService {

    void createWorkOrder(WorkOrderDTO workOrderDTO);
    void updateWorkOrder(WorkOrderDTO workOrderDTO);
    void updateWorkOrdersEngineer(EngineerSaveWorkOrderDTO workOrderDTO);
    void updateChatLogInWorkOrders(ChatLogDTO chatLogDTO);
    void updateIsNeedCall(IsNeedCallDTO isNeedCallDTO);
    void updateIsDone(IsDoneDTO isDoneDTO);
    void updateIsDoneIsCalled(IsDoneIsCalledDTO isDoneIsCalledDTO);
    void updateIsWaitingParts(IsWaitingSparePartsDTO isWaitingSparePartsDTO);
    void updateIsGivenOut(GivenOutDTO givenOutDTO);

    WorkOrderDtoPresent getByNum(Integer id);

    List<WorkOrderDtoPresent> findAllWorkOrders();
    List<WorkOrderDtoPresent> findAllWorkOrdersIsNeedCall(Boolean isNeedCall);
    List<WorkOrderDtoPresent> findAllByIsDone(Boolean isDone);
    List<WorkOrderDtoPresent> findAllWorkOrdersCreatedAt();
    List<WorkOrderDtoPresent> findAllByEngineerAndiAndIsAccepted(Integer id, Boolean isAccepted, Boolean isDone);

}
