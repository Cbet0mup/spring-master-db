package ru.database.springmasterdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDTOpresent;
import ru.database.springmasterdb.store.*;

import java.time.LocalDateTime;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {


    // private final Logger log = LoggerFactory.getLogger(getClass());

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
                    .getById(workOrderDTO.getEngineerId());

            Manufacturer manufacturer = manufacturerRepo
                    .getById(workOrderDTO.getManufacturerId());

            Product product = productRepo
                    .getById(workOrderDTO.getProductId());

            Receiver receiver = receiverRepo
                    .getById(workOrderDTO.getReceiverId());

            ServiceOrder serviceOrder = serviceOrderRepo
                    .getById(workOrderDTO.getServiceId());

            Status status = statusRepo
                    .getById(workOrderDTO.getStatusId());

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
    public WorkOrderDTOpresent getByNum(Integer id) {
        WorkOrder workOrder = workOrderRepo.getById(id);

        WorkOrderDTOpresent workOrderDTOpr = new WorkOrderDTOpresent();

        workOrderDTOpr.setCustomerName(workOrder.getCustomerName())
                .setCustomerPhone(workOrder.getCustomerPhone())
                .setSerialNumber(workOrder.getSerialNumber())
                .setEngineerName(workOrder.getEngineer().getEngineerName())
                .setManufacturerName(workOrder.getManufacturer().getManufacturerName())
                .setProductName(workOrder.getProduct().getProductName())
                .setReceiverName(workOrder.getReceiver().getReceiverName())
                .setServiceName(workOrder.getService().getServiceType())
                .setStatusName(workOrder.getStatus().getStatusName())
                .setCreatedAt(workOrder.getCreatedAt());

        return workOrderDTOpr;
    }
}
