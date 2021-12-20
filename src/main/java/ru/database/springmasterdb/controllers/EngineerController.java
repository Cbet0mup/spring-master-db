package ru.database.springmasterdb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.*;
import ru.database.springmasterdb.services.WorkOrderServiceImpl;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://xn--80aaabrq9ba6exc.xn--h1ahn.xn--p1acf")
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping(path = "/api/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class EngineerController {

    private final WorkOrderServiceImpl workOrderServiceImpl;


    public EngineerController(WorkOrderServiceImpl workOrderServiceImpl) {
        this.workOrderServiceImpl = workOrderServiceImpl;
    }

    @PostMapping("/chatlog")          //изменить chatLog
    public ResponseEntity<ChatLogDTO> updateChatLog(@RequestBody ChatLogDTO chatLogDTO) {
        workOrderServiceImpl.updateChatLogInWorkOrders(chatLogDTO);
        return new ResponseEntity<>(chatLogDTO, HttpStatus.OK);
    }

    @PostMapping("/engineersaveworkorder")
    //изменение заказа/наряда (выявленная неисправность и описание работ)
    public ResponseEntity<EngineerSaveWorkOrderDTO> updateWorkOrder(@RequestBody EngineerSaveWorkOrderDTO workOrderDTO) {
        workOrderServiceImpl.updateWorkOrdersEngineer(workOrderDTO);
        return new ResponseEntity<>(workOrderDTO, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/allNeedRepair/{id}")  //найти все принятые на конкретного инженера.
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrdersIsAccepted(@PathVariable("id") Integer id) {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllByEngineerAndiAndIsAccepted(id, true, false);
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

    @PostMapping("/needCall")            //связь с клиентом статус
    public ResponseEntity<IsNeedCallDTO> createWorkOrder(@RequestBody IsNeedCallDTO isNeedCallDTO) {
        workOrderServiceImpl.updateIsNeedCall(isNeedCallDTO);
        return new ResponseEntity<>(isNeedCallDTO, HttpStatus.CREATED);
    }

    @PostMapping("/isDone")            //статус наряда isDone готов/true - в работе/false мастером
    public ResponseEntity<IsDoneDTO> createWorkOrder(@RequestBody IsDoneDTO isDoneDTO) {
        workOrderServiceImpl.updateIsDone(isDoneDTO);
        return new ResponseEntity<>(isDoneDTO, HttpStatus.CREATED);
    }

    @PostMapping("/isDoneIsCalled")            //статус наряда: готов - клиент извещён
    public ResponseEntity<IsDoneIsCalledDTO> createWorkOrder(@RequestBody IsDoneIsCalledDTO isDoneDTO) {
        workOrderServiceImpl.updateIsDoneIsCalled(isDoneDTO);
        return new ResponseEntity<>(isDoneDTO, HttpStatus.CREATED);
    }

    @PostMapping("/isWaitingSpareParts")            //статус наряда isDone готов/true - в работе/false мастером
    public ResponseEntity<IsWaitingSparePartsDTO> createWorkOrder(@RequestBody IsWaitingSparePartsDTO isWaitingSparePartsDTO) {
        workOrderServiceImpl.updateIsWaitingParts(isWaitingSparePartsDTO);
        return new ResponseEntity<>(isWaitingSparePartsDTO, HttpStatus.CREATED);
    }
}
