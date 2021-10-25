package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.store.WorkOrder;

@Component
public class WorkOrderDTOFactory {
    public WorkOrderDtoPresent createWorkOrderDTOPresent(WorkOrder workOrder) {
        return WorkOrderDtoPresent.builder()
                .id(workOrder.getId())
                .createdAt(workOrder.getCreatedAt())
                .givenOut(workOrder.getGivenOut())
                .dateOfIssue(workOrder.getDateOfIssue())
                .customerName(workOrder.getCustomerName())
                .customerPhone(workOrder.getCustomerPhone())
                .engineerName(workOrder.getEngineer().getEngineerName())
                .manufacturerName(workOrder.getManufacturer().getManufacturerName())
                .productName(workOrder.getProduct().getProductName())
                .receiverName(workOrder.getReceiver().getReceiverName())
                .price(workOrder.getPrice().getPrice())
                .priceName(workOrder.getPrice().getPriceName())
                .finalPrice(workOrder.getFinalPrice())
                .prepayment(workOrder.getPrepayment())
                .serialNumber(workOrder.getSerialNumber())
                .imei(workOrder.getImei())
                .serviceName(workOrder.getService().getServiceType())
                .modelName(workOrder.getModel().getModelName())
                .isDone(workOrder.getIsDone())
                .isDoneIsCalled(workOrder.getIsDoneIsCalled())
                .isGivenOut(workOrder.getIsGivenOut())
                .isNeedCall(workOrder.getIsNeedCall())
                .complection(workOrder.getComplection())
                .look(workOrder.getLook())
                .trouble(workOrder.getTrouble())
                .troubleDetected(workOrder.getTroubleDetected())
                .troubleSolving(workOrder.getTroubleSolving())
                .chatLog(workOrder.getChatLog())

                .priceId(workOrder.getPrice().getId())
                .modelId(workOrder.getModel().getId())
                .serviceId(workOrder.getService().getId())
                .productId(workOrder.getProduct().getId())
                .manufacturerId(workOrder.getManufacturer().getId())
                .receiverId(workOrder.getReceiver().getId())
                .engineerId(workOrder.getEngineer().getId())
                .statusId(workOrder.getStatus().getId())
                .build();

    }
}


