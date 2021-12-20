package ru.database.springmasterdb.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.database.springmasterdb.services.EngineerServiceImpl;
import ru.database.springmasterdb.services.ReceiverServiceImpl;

@RestController
//@CrossOrigin(origins = "http://xn--80aaabrq9ba6exc.xn--h1ahn.xn--p1acf")
@CrossOrigin(origins = "http://localhost:3000")

@RequestMapping(path = "/api/managment", produces = MediaType.APPLICATION_JSON_VALUE)
public class ManagementController {

    private final EngineerServiceImpl engineerService;
    private final ReceiverServiceImpl receiverService;

    public ManagementController(EngineerServiceImpl engineerService, ReceiverServiceImpl receiverService) {
        this.engineerService = engineerService;
        this.receiverService = receiverService;
    }
}
