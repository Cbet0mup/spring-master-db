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
                .customerName(workOrder.getCustomerName())
                .customerPhone(workOrder.getCustomerPhone())
                .engineerName(workOrder.getEngineer().getEngineerName())
                .manufacturerName(workOrder.getManufacturer().getManufacturerName())
                .productName(workOrder.getProduct().getProductName())
                .receiverName(workOrder.getReceiver().getReceiverName())
                .price(workOrder.getPrice().getPrice())
                .priceName(workOrder.getPrice().getPriceName())
                .finalPrice(workOrder.getFinalPrice())
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
                .build();

    }
}


