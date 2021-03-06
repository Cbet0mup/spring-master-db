package ru.database.springmasterdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.*;
import ru.database.springmasterdb.factories.WorkOrderDTOFactory;
import ru.database.springmasterdb.factories.WorkOrderFactory;
import ru.database.springmasterdb.factories.WorkOrdersUpdateFactory;
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
    private final WorkOrdersUpdateFactory workOrdersUpdateFactory;
    private final PriceRepo priceRepo;


    @Autowired
    public WorkOrderServiceImpl(WorkOrderRepo workOrderRepo, EngineerRepo engineerRepo, ManufacturerRepo manufacturerRepo,
                                ProductRepo productRepo, ReceiverRepo receiverRepo, ServiceOrderRepo serviceOrderRepo, PriceRepo priceRepo,
                                StatusRepo statusRepo, WorkOrderDTOFactory workOrderDTOFactory, WorkOrderFactory workOrderFactory, ModelRepo modelRepo, WorkOrdersUpdateFactory workOrdersUpdateFactory) {
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
        this.workOrdersUpdateFactory = workOrdersUpdateFactory;
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

            //???????????????? ?????? ??????????/?????????? ???? ?????????? ?????????????????????? ????????
            WorkOrder workOrder = workOrderFactory.createWorkOrder(workOrderDTO, engineer, manufacturer,
                    product, receiver, serviceOrder, status, modelName, price);

            workOrderRepo.saveAndFlush(workOrder);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override           //?????????????????? ????????????/????????????
    public void updateWorkOrder(WorkOrderDTO workOrderDTO) {
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

            WorkOrder workOrder = workOrdersUpdateFactory.updateWorkOrder(workOrderDTO, engineer, manufacturer,
                    product, receiver, serviceOrder, status, modelName, price);

            workOrderRepo.saveAndFlush(workOrder);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override  //?????????????????? ????????????/???????????? (???????????????????? ?????????????????????????? ?? ???????????????? ??????????)
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

    @Override           //????????????????????
    public void updateChatLogInWorkOrders(ChatLogDTO chatLogDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(chatLogDTO.getId());
            workOrder.setChatLog(chatLogDTO.getChatLog());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override       //???????????????????? ?????????? ???? ?????????? ?? ??????????????????
    public void updateIsNeedCall(IsNeedCallDTO isNeedCallDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(isNeedCallDTO.getId());
            workOrder.setIsNeedCall(isNeedCallDTO.getIsNeedCall());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override       //?????????????????? ?????????????? ???????????? ?????????????????? ?? ?????????????????? ?????? ??????????????
    public void updateIsDone(IsDoneDTO isDoneDTO) {

        try {
            WorkOrder workOrder = workOrderRepo.getById(isDoneDTO.getId());
            workOrder
                    .setIsDone(isDoneDTO.getIsDone())
                    .setIsNeedCall(false);
            if (isDoneDTO.getIsDone()){         //???????? ?????????? ???? ???????????? ????????
                LocalDate localDate = LocalDate.now();
                workOrder.setDateOfIssue(String.format(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), localDate))
                        .setIsAccepted(false)
                        .setIsNeedCall(false);
            }   else {
                workOrder.setDateOfIssue("");   //???????? ?????????????? ???? ?????????????? ????????
                workOrder.setIsDoneIsCalled(false);     //???????? ?????????????? ???? ?????????????????????? ???? ?????????????? ???????? ????????
                workOrder.setIsAccepted(true);      //???????????????????? ????????????????
            }
            if (workOrder.getIsGivenOut()){
                workOrder.setIsGivenOut(false)         //???????? ?????? ?????????? ???? ??????????????
                        .setIsDone(false)
                        .setIsAccepted(true);

            }

            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override           /// ????????????: ?????????? - ???????????? ??????????????
    public void updateIsDoneIsCalled(IsDoneIsCalledDTO isDoneIsCalledDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(isDoneIsCalledDTO.getId());
            workOrder
                    .setIsDoneIsCalled(true)
                    .setIsDone(false);
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override                                                                           //?????????????? ????????????
    public void updateIsWaitingParts(IsWaitingSparePartsDTO isWaitingSparePartsDTO) {
        try {
            WorkOrder workOrder = workOrderRepo.getById(isWaitingSparePartsDTO.getId());
            workOrder.setIsWaitingForASpareParts(isWaitingSparePartsDTO.getIsWaitingForASpareParts());
            workOrderRepo.saveAndFlush(workOrder);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override                                                   //???????????? ??????????????
    public void updateIsGivenOut(GivenOutDTO givenOutDTO) {
        LocalDate localDate = LocalDate.now();
        try {
            WorkOrder workOrder = workOrderRepo.getById(givenOutDTO.getId());
            workOrder                                                           //???????????????? ?????? ?????????????? ?? ???????????????????? ???????? ???????????? ?????????????? ???? ????????
                    .setIsGivenOut(true)
                    .setIsDone(false)
                    .setIsAccepted(false)
                    .setIsDoneIsCalled(false)
                    .setIsDone(false)
                    .setIsWaitingForASpareParts(false)
                    .setGivenOut(String.format(LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy")), localDate));

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

    @Override                       //??????
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

    @Override           //?????? ??????????????
    public List<WorkOrderDtoPresent> findAllByIsDone(Boolean isDone) {
        List<WorkOrderDtoPresent> workOrderDtoPresents = null;

        try {
            Sort isNeedCallSort = Sort.by(Sort.Direction.ASC, "id");

            List<WorkOrder> workOrderListRepo = workOrderRepo.findAllByIsDoneAndIsDoneIsCalled(isDone, true, isNeedCallSort);

            workOrderDtoPresents = new ArrayList<>();
            for (WorkOrder workOrder : workOrderListRepo) {
                workOrderDtoPresents.add(workOrderDTOFactory.createWorkOrderDTOPresent(workOrder));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return workOrderDtoPresents;
    }

    @Override                   // ?????? ?????????????????? ?????????????? ?? ????????????????
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

    @Override               // ?????? ?? ?????????????? ??????????
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