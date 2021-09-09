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
                .customerName(workOrder.getCustomerName())
                .customerPhone(workOrder.getCustomerPhone())
                .engineerName(workOrder.getEngineer().getEngineerName())
                .manufacturerName(workOrder.getManufacturer().getManufacturerName())
                .productName(workOrder.getProduct().getProductName())
                .receiverName(workOrder.getReceiver().getReceiverName())
                .serialNumber(workOrder.getSerialNumber())
                .serviceName(workOrder.getService().getServiceType())
                .modelName(workOrder.getModel().getModelName())
                .build();

    }
}


