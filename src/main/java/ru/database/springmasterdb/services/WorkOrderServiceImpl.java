package ru.database.springmasterdb.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.exceptions.*;
import ru.database.springmasterdb.store.*;

import java.time.LocalDateTime;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {


    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WorkOrderRepo workOrderRepo;
    private final EngineerRepo engineerRepo;
    private final ManufacturerRepo manufacturerRepo;
    private final ProductRepo productRepo;
    private final ReceiverRepo receiverRepo;
    private final ServiceOrderRepo serviceOrderRepo;
    private final StatusRepo statusRepo;

    @Autowired
    public WorkOrderServiceImpl(WorkOrderRepo workOrderRepo, EngineerRepo engineerRepo, ManufacturerRepo manufacturerRepo,
                                ProductRepo productRepo, ReceiverRepo receiverRepo, ServiceOrderRepo serviceOrderRepo,
                                StatusRepo statusRepo) {
        this.workOrderRepo = workOrderRepo;
        this.engineerRepo = engineerRepo;
        this.manufacturerRepo = manufacturerRepo;
        this.productRepo = productRepo;
        this.receiverRepo = receiverRepo;
        this.serviceOrderRepo = serviceOrderRepo;
        this.statusRepo = statusRepo;
    }

    @Override
    @Transactional                                          //для чтения (readOnly = true)
    public void createWorkOrder(WorkOrderDTO workOrderDTO) {
        try {
            Engineer engineer = engineerRepo
                    .getById(workOrderDTO.getEngineerId());//.findById(workOrderDTO.getEngineerId())
                    //.orElseThrow(() -> new EngineerNotFoundException("this Engineer not found"));

            Manufacturer manufacturer = manufacturerRepo
                    .getById(workOrderDTO.getManufacturerId());
//                    .findById(workOrderDTO.getManufacturerId())
//                    .orElseThrow(() -> new ManufacturerNotFoundException("this manufacturer not found"));

            Product product = productRepo
                    .getById(workOrderDTO.getProductId());
//                    .findById(workOrderDTO.getProductId())
//                    .orElseThrow(() -> new ProductNotFoundException("this product not found"));

            Receiver receiver = receiverRepo
                    .getById(workOrderDTO.getReceiverId());
//                    .findById(workOrderDTO.getReceiverId())
//                    .orElseThrow(() -> new ReceiverNotFoundException("this receiver not found"));
            ServiceOrder serviceOrder = serviceOrderRepo
                    .getById(workOrderDTO.getServiceId());
//                    .findById(workOrderDTO.getServiceId())
//                    .orElseThrow(() -> new ServiceOrderNotFoundException("this serviceOrder not found"));
            Status status = statusRepo
                    .getById(workOrderDTO.getStatusId());
//                    .findById(workOrderDTO.getStatusId())
//                    .orElseThrow(() -> new StatusNotFoundException("this status not found"));

            //Собираем наш заказ/наряд из всего полученного выше
            WorkOrder workOrder = new WorkOrder();
            workOrder.setCreatedAt(LocalDateTime.now())
                    .setCustomerName(workOrderDTO.getCustomerName())
                    .setCustomerPhone(workOrderDTO.getCustomerPhone())
                    .setSerialNumber(workOrderDTO.getSerialNumber())
                    .setEngineer(engineer)
                    .setManufacturer(manufacturer)
                    .setProduct(product)
                    .setReceiver(receiver)
                    .setService(serviceOrder)
                    .setStatus(status);

            workOrderRepo.saveAndFlush(workOrder);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void findById() {

    }
}
