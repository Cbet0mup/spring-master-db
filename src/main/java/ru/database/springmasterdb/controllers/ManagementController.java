package ru.database.springmasterdb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.database.springmasterdb.dto.WorkOrderDtoPresent;
import ru.database.springmasterdb.services.EngineerServiceImpl;
import ru.database.springmasterdb.services.ReceiverServiceImpl;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://xn--80aaabrq9ba6exc.xn--h1ahn.xn--p1acf")
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping(path = "/api/managment", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagementController {


    public ManagementController() {

    }
    @GetMapping("/findworkorder/all")  //
    public ResponseEntity<List<WorkOrderDtoPresent>> getAllWorkOrders() {
        List<WorkOrderDtoPresent> workOrderDTOpr = null;// workOrderServiceImpl.findAllWorkOrders();
        return new ResponseEntity<>(workOrderDTOpr, HttpStatus.OK);
    }

}
