package ru.database.springmasterdb.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.ChatLogDTO;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.services.WorkOrderServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class WorkOrderController {

    private final Logger log = LoggerFactory.getLogger(getClass());


    private final WorkOrderServiceImpl workOrderServiceImpl;


    @Autowired
    public WorkOrderController(WorkOrderServiceImpl workOrderServiceImpl) {
        this.workOrderServiceImpl = workOrderServiceImpl;

    }

    @PostMapping            //новый наряд
    public ResponseEntity<WorkOrderDTO> createWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {
        workOrderServiceImpl.createWorkOrder(workOrderDTO);
        return new ResponseEntity<>(workOrderDTO, HttpStatus.CREATED);
    }

    //обновить ChatLog
    @PostMapping("/chatlog")          //изменить chatLog
    public ResponseEntity<ChatLogDTO> updateChatLog(@RequestBody ChatLogDTO chatLogDTO) {
        workOrderServiceImpl.updateChatLogInWorkOrders(chatLogDTO);
        return new ResponseEntity<>(chatLogDTO, HttpStatus.OK);
    }

    @PutMapping           //изменение заказа/наряда
    public ResponseEntity<WorkOrderDTO> updateWorkOrder(@RequestBody WorkOrderDTO workOrderDTO) {

        return new ResponseEntity<>(workOrderDTO, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/{id}")  //найти один по номеру
    public ResponseEntity<WorkOrderDtoPresent> getWorkorderById(@PathVariable("id") Integer id) {
        WorkOrderDtoPresent workOrderDTOpr = workOrderServiceImpl.getByNum(id);
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/all")  // найти все
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrders() {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllWorkOrders();
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/isdone/{isDone}") /// найти все готовые
    public ResponseEntity<List<WorkOrderDtoPresent>> findByIsDone(@PathVariable("isDone") Boolean isDone) {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllByIsDone(isDone);
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/isneedcall/{isNeedCall}")  //найти все требующие обзвона
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrdersIsNeedCall(@PathVariable("isNeedCall") Boolean isNeedCall) {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllWorkOrdersIsNeedCall(isNeedCall);
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/allNow")  //найти все c текущей датой
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrdersIsNeedCall() {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllWorkOrdersCreatedAt();
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/allNeedRepair/{id}")  //найти все принятые на конкретного инженера.
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrdersIsAccepted(@PathVariable("id") Integer id) {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllByEngineerAndiAndIsAccepted(id, true);
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }
}
