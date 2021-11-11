package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.store.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class WorkOrderFactory {
    public WorkOrder createWorkOrder(WorkOrderDTO workOrderDTO, Engineer engineer, Manufacturer manufacturer,
                                     Product product, Receiver receiver, ServiceOrder serviceOrder, Status status, ModelName modelName,
                                     Price price){
LocalDate localDate = LocalDate.now();
        return WorkOrder.builder()
                .createdAt(String.format(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), localDate)) //.ISO_LOCAL_DATE
                .customerName(workOrderDTO.getCustomerName())
                .customerPhone(workOrderDTO.getCustomerPhone())
                .chatLog(workOrderDTO.getChatLog())

                .price(price)
                .finalPrice(workOrderDTO.getFinalPrice())
                .prepayment(workOrderDTO.getPrepayment())
                .additionalPrice(workOrderDTO.getAdditionalPrice())

                .imei(workOrderDTO.getImei())
                .serialNumber(workOrderDTO.getSerialNumber())
                .engineer(engineer)
                .manufacturer(manufacturer)
                .product(product)
                .receiver(receiver)
                .service(serviceOrder)
                .status(status)
                .model(modelName)
                .isNeedCall(workOrderDTO.getIsNeedCall())
                .isAccepted(workOrderDTO.getIsAccepted())
                .isDone(workOrderDTO.getIsDone())
                .isDoneIsCalled(workOrderDTO.getIsDoneIsCalled())
                .isGivenOut(workOrderDTO.getIsGivenOut())
                .isWaitingForASpareParts(workOrderDTO.getIsWaitingForASpareParts())
                .look(workOrderDTO.getLook())
                .complection(workOrderDTO.getComplection())
                .trouble(workOrderDTO.getTrouble())
                .troubleDetected(workOrderDTO.getTroubleDetected())
                .troubleSolving(workOrderDTO.getTroubleSolving())
                .build();
    }
}
