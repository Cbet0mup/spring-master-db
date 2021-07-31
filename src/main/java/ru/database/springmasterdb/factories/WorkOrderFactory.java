package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.store.*;

import java.time.LocalDateTime;

@Component
public class WorkOrderFactory {
    public WorkOrder createWorkOrder(WorkOrderDTO workOrderDTO, Engineer engineer, Manufacturer manufacturer,
                                     Product product, Receiver receiver, ServiceOrder serviceOrder, Status status){
        return WorkOrder.builder()
                .createdAt(LocalDateTime.now())
                .customerName(workOrderDTO.getCustomerName())
                .customerPhone(workOrderDTO.getCustomerPhone())
                .serialNumber(workOrderDTO.getSerialNumber())
                .engineer(engineer)
                .manufacturer(manufacturer)
                .product(product)
                .receiver(receiver)
                .service(serviceOrder)
                .status(status)
                .build();
    }
}
