package ru.database.springmasterdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.factories.WorkOrderDTOFactory;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.factories.WorkOrderFactory;
import ru.database.springmasterdb.store.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkOrderServiceImpl implements WorkOrderService {

    private final WorkOrderRepo workOrderRepo;
    private final EngineerRepo engineerRepo;
    private final ManufacturerRepo manufacturerRepo;
    private final ProductRepo productRepo;
    private final ReceiverRepo receiverRepo;
    private final ServiceOrderRepo serviceOrderRepo;
    private final StatusRepo statusRepo;
    private final ModelRepo modelRepo;
    private final WorkOrderDTOFactory workOrderDTOFactory;
    private final WorkOrderFactory workOrderFactory;

    @Autowired
    public WorkOrderServiceImpl(WorkOrderRepo workOrderRepo, EngineerRepo engineerRepo, ManufacturerRepo manufacturerRepo,
                                ProductRepo productRepo, ReceiverRepo receiverRepo, ServiceOrderRepo serviceOrderRepo,
                                StatusRepo statusRepo, WorkOrderDTOFactory workOrderDTOFactory, WorkOrderFactory workOrderFactory, ModelRepo modelRepo) {
        this.workOrderRepo = workOrderRepo;
        this.engineerRepo = engineerRepo;
        this.manufacturerRepo = manufacturerRepo;
        this.productRepo = productRepo;
        this.receiverRepo = receiverRepo;
        this.serviceOrderRepo = serviceOrderRepo;
        this.statusRepo = statusRepo;
        this.workOrderDTOFactory = workOrderDTOFactory;
        this.workOrderFactory = workOrderFactory;
        this.modelRepo = modelRepo;
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

            ModelName modelName = modelRepo
                    .getById(workOrderDTO.getModelId());

            //Собираем наш заказ/наряд из всего полученного выше
            WorkOrder workOrder = workOrderFactory.createWorkOrder(workOrderDTO, engineer, manufacturer,
                    product, receiver, serviceOrder, status, modelName);

            workOrderRepo.saveAndFlush(workOrder);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public WorkOrderDtoPresent getByNum(Integer id) {
        WorkOrder workOrder = workOrderRepo.getById(id);

        return workOrderDTOFactory.createWorkOrderDTOPresent(workOrder);
    }

    @Override
    public List<WorkOrderDtoPresent> findAllByIsDone(Boolean isDone) {
        List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByIsDone(isDone);
        List<WorkOrderDtoPresent> workOrderDtoPresents = new ArrayList<>();
        for (WorkOrder workOrder : workOrderListRepo) {
            workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
        }

        return workOrderDtoPresents;
    }

    @Override
    public List<WorkOrderDtoPresent> findAllWorkOrders() {
        List<WorkOrder> workOrderListRepo = workOrderRepo.findAll();
        List<WorkOrderDtoPresent> workOrderDtoPresents = new ArrayList<>();
        for (WorkOrder workOrder : workOrderListRepo) {
            workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
        }

        return workOrderDtoPresents;
    }

    @Override
    public List<WorkOrderDtoPresent> findAllWorkOrdersIsNeedCall(Boolean isNeedCall) {
        Sort isNeedCallSort = Sort.by(Sort.Direction.ASC, "id");
        List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByIsNeedCall(isNeedCall);

        List<WorkOrderDtoPresent> workOrderDtoPresents = new ArrayList<>();
        for (WorkOrder workOrder : workOrderListRepo) {
            workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
        }

        return workOrderDtoPresents;
    }


}
