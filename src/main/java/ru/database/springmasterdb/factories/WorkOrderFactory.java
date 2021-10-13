package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.store.*;

import java.time.LocalDateTime;

@Component
public class WorkOrderFactory {
    public WorkOrder createWorkOrder(WorkOrderDTO workOrderDTO, Engineer engineer, Manufacturer manufacturer,
                                     Product product, Receiver receiver, ServiceOrder serviceOrder, Status status, ModelName modelName,
                                     Price price){
        return WorkOrder.builder()
                .createdAt(LocalDateTime.now())
                .customerName(workOrderDTO.getCustomerName())
                .customerPhone(workOrderDTO.getCustomerPhone())
                .serialNumber(workOrderDTO.getSerialNumber())
                .price(price)
                .finalPrice(workOrderDTO.getFinalPrice())
                .imei(workOrderDTO.getImei())
                .engineer(engineer)
                .manufacturer(manufacturer)
                .product(product)
                .receiver(receiver)
                .service(serviceOrder)
                .status(status)
                .model(modelName)
                .isNeedCall(workOrderDTO.getIsNeedCall())
                .isDone(workOrderDTO.getIsDone())
                .isDoneIsCalled(workOrderDTO.getIsDoneIsCalled())
                .isGivenOut(workOrderDTO.getIsGivenOut())
                .look(workOrderDTO.getLook())
                .complection(workOrderDTO.getComplection())
                .trouble(workOrderDTO.getTrouble())
                .build();
    }
}
