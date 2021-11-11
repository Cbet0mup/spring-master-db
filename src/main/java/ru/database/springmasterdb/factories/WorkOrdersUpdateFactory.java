package ru.database.springmasterdb.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.*;
import ru.database.springmasterdb.services.WorkOrderService;
import ru.database.springmasterdb.store.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class WorkOrdersUpdateFactory {
    private final WorkOrderRepo workOrderRepo;

    public WorkOrdersUpdateFactory(WorkOrderRepo workOrderRepo) {
        this.workOrderRepo = workOrderRepo;
    }

    public WorkOrder updateWorkOrder(WorkOrderDTO workOrderDTO, Engineer engineer, Manufacturer manufacturer,
                                     Product product, Receiver receiver, ServiceOrder serviceOrder, Status status, ModelName modelName,
                                     Price price){
        WorkOrder workOrder = workOrderRepo.getById(workOrderDTO.getId());


        return workOrder
                .setCustomerName(workOrderDTO.getCustomerName())
                .setCustomerPhone(workOrderDTO.getCustomerPhone())
                .setSerialNumber(workOrderDTO.getSerialNumber())
                .setImei(workOrderDTO.getImei())
                .setLook(workOrderDTO.getLook())
                .setComplection(workOrderDTO.getComplection())
                .setTrouble(workOrderDTO.getTrouble())
                .setTroubleDetected(workOrderDTO.getTroubleDetected())
                .setTroubleSolving(workOrderDTO.getTroubleSolving())
                .setPrepayment(workOrderDTO.getPrepayment())
                .setFinalPrice(workOrderDTO.getFinalPrice())
                .setAdditionalPrice(workOrderDTO.getAdditionalPrice())
                .setIsDone(workOrderDTO.getIsDone())
                .setIsNeedCall(workOrderDTO.getIsNeedCall())
                .setIsDoneIsCalled(workOrderDTO.getIsDoneIsCalled())
                .setIsGivenOut(workOrderDTO.getIsGivenOut())
                .setIsAccepted(workOrderDTO.getIsAccepted())
                .setIsWaitingForASpareParts(workOrderDTO.getIsWaitingForASpareParts())
                .setEngineer(engineer)
                .setManufacturer(manufacturer)
                .setProduct(product)
                .setReceiver(receiver)
                .setService(serviceOrder)
                .setStatus(status)
                .setModel(modelName)
                .setPrice(price);
        
    }
}



