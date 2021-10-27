package ru.database.springmasterdb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.ChatLogDTO;
import ru.database.springmasterdb.dto.EngineerSaveWorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDTO;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.services.WorkOrderServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
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

    @PostMapping("/engineersaveworkorder")           //изменение заказа/наряда (выявленная неисправность и описание работ)
    public ResponseEntity<EngineerSaveWorkOrderDTO> updateWorkOrder(@RequestBody EngineerSaveWorkOrderDTO workOrderDTO) {
            workOrderServiceImpl.updateWorkOrdersEngineer(workOrderDTO);
        return new ResponseEntity<>(workOrderDTO, HttpStatus.OK);
    }

    @GetMapping("/findworkorder/allNeedRepair/{id}")  //найти все принятые на конкретного инженера.
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrdersIsAccepted(@PathVariable("id") Integer id) {
        List<WorkOrderDtoPresent> workOrderDTOpr = workOrderServiceImpl.findAllByEngineerAndiAndIsAccepted(id, true);
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }
}
