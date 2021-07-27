package ru.database.springmasterdb.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dao.WorkOrderDTO;
import ru.database.springmasterdb.exceptions.EngineerNotFoundException;
import ru.database.springmasterdb.services.WorkOrderServiceInterface;
import ru.database.springmasterdb.store.entities.Engineer;
import ru.database.springmasterdb.store.entities.WorkOrder;
import ru.database.springmasterdb.store.repositories.EngineerRepo;
import ru.database.springmasterdb.store.repositories.WorkOrderRepo;

@Service
public class WorkOrderService implements WorkOrderServiceInterface {


    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WorkOrderRepo workOrderRepo;
    private final EngineerRepo engineerRepo;

    @Autowired
    public WorkOrderService(WorkOrderRepo workOrderRepo, EngineerRepo engineerRepo) {
        this.workOrderRepo = workOrderRepo;
        this.engineerRepo = engineerRepo;
    }

    @Override
    public void createWorkOrder(WorkOrderDTO workOrderDTO) throws EngineerNotFoundException {
        //ObjectMapper objectMapper = new ObjectMapper();

       try{
           Engineer engineer = engineerRepo
                   .findById(workOrderDTO.getEngineerId())
                   .orElseThrow(() -> new EngineerNotFoundException("this Engineer not found"));

           WorkOrder workOrder = new WorkOrder();
           workOrder.setEngineer(engineer);
           workOrderRepo.save(workOrder);
           log.info("заказ-наряд создан");
       }catch (Exception e){
           e.printStackTrace();
       }


    }

    @Override
    public void findById() {

    }
}
