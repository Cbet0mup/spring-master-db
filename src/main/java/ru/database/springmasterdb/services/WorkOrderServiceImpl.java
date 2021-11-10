package ru.database.springmasterdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.*;
import ru.database.springmasterdb.factories.WorkOrderDTOFactory;
import ru.database.springmasterdb.factories.WorkOrderFactory;
import ru.database.springmasterdb.store.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    private final PriceRepo priceRepo;

    @Autowired
    public WorkOrderServiceImpl(WorkOrderRepo workOrderRepo, EngineerRepo engineerRepo, ManufacturerRepo manufacturerRepo,
                                ProductRepo productRepo, ReceiverRepo receiverRepo, ServiceOrderRepo serviceOrderRepo, PriceRepo priceRepo,
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
        this.priceRepo = priceRepo;
    }

    @Override
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
            Price price = priceRepo
                    .getById(workOrderDTO.getPriceId());

            //Собираем наш заказ/наряд из всего полученного выше
            WorkOrder workOrder = workOrderFactory.createWorkOrder(workOrderDTO, engineer, manufacturer,
                    product, receiver, serviceOrder, status, modelName, price);

            workOrderRepo.saveAndFlush(workOrder);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override           //изменение заказа/наряда
    public void updateWorkOrder(WorkOrderDTO workOrderDTO) {

    }

    @Override  //изменение заказа/наряда (выявленная неисправность и описание работ)
    public void updateWorkOrdersEngineer(EngineerSaveWorkOrderDTO workOrderDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(workOrderDTO.getId());
            workOrder
                    .setTroubleDetected(workOrderDTO.getTroubleDetected())
                    .setTroubleSolving(workOrderDTO.getTroubleSolving());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override           //примечания
    public void updateChatLogInWorkOrders(ChatLogDTO chatLogDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(chatLogDTO.getId());
            workOrder.setChatLog(chatLogDTO.getChatLog());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override       //отправляем заказ на связь с клиентьом
    public void updateIsNeedCall(IsNeedCallDTO isNeedCallDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(isNeedCallDTO.getId());
            workOrder.setIsNeedCall(isNeedCallDTO.getIsNeedCall());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override       //оперируем выдачей заказа инженером и возвратом его обратно
    public void updateIsDone(IsDoneDTO isDoneDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(isDoneDTO.getId());
            workOrder.setIsDone(isDoneDTO.getIsDone());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public WorkOrderDtoPresent getByNum(Integer id) {
        WorkOrder workOrder = null;
        try {
            workOrder = workOrderRepo.getById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assert workOrder != null;
        return workOrderDTOFactory.createWorkOrderDTOPresent(workOrder);
    }

    @Override                       //все
    public List<WorkOrderDtoPresent> findAllWorkOrders() {
        List<WorkOrderDtoPresent> workOrderDtoPresents = null;

        try {
            Sort isNeedCallSort = Sort.by(Sort.Direction.ASC, "id");

            List<WorkOrder> workOrderListRepo = workOrderRepo.findAll(isNeedCallSort);

            workOrderDtoPresents = new ArrayList<>();
            for (WorkOrder workOrder : workOrderListRepo) {
                workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workOrderDtoPresents;
    }

    @Override           //все готовые
    public List<WorkOrderDtoPresent> findAllByIsDone(Boolean isDone) {
        List<WorkOrderDtoPresent> workOrderDtoPresents = null;

        try {
            Sort isNeedCallSort = Sort.by(Sort.Direction.ASC, "id");

            List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByIsDone(isDone, isNeedCallSort);

            workOrderDtoPresents = new ArrayList<>();
            for (WorkOrder workOrder : workOrderListRepo) {
                workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workOrderDtoPresents;
    }

    @Override                   // все требующие созвона с клиентом
    public List<WorkOrderDtoPresent> findAllWorkOrdersIsNeedCall(Boolean isNeedCall) {
        Sort isNeedCallSort = Sort.by(Sort.Direction.ASC, "id");

        List<WorkOrderDtoPresent> workOrderDtoPresents = null;
        try {
            List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByIsNeedCall(isNeedCall, isNeedCallSort);

            workOrderDtoPresents = new ArrayList<>();
            for (WorkOrder workOrder : workOrderListRepo) {
                workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workOrderDtoPresents;
    }

    @Override               // все с текущей датой
    public List<WorkOrderDtoPresent> findAllWorkOrdersCreatedAt() {
        Sort createdAt = Sort.by(Sort.Direction.ASC, "id");
        LocalDate localDate = LocalDate.now();

        List<WorkOrderDtoPresent> workOrderDtoPresents = null;
        try {
            String date = String.format(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), localDate);

            List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByCreatedAt(date, createdAt);

            workOrderDtoPresents = new ArrayList<>();
            for (WorkOrder workOrder : workOrderListRepo) {
                workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workOrderDtoPresents;
    }

    @Override
    public List<WorkOrderDtoPresent> findAllByEngineerAndiAndIsAccepted(Integer id, Boolean isAccepted, Boolean isDone) {
        Sort createdAt = Sort.by(Sort.Direction.ASC, "id");
        List<WorkOrderDtoPresent> workOrderDtoPresents = null;
        try {
            List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByEngineerAndIsAcceptedAnAndIsDone(id, isAccepted, isDone, createdAt);
            System.out.println(workOrderListRepo);

            workOrderDtoPresents = new ArrayList<>();
            for (WorkOrder workOrder : workOrderListRepo) {
                workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workOrderDtoPresents;
    }


}
