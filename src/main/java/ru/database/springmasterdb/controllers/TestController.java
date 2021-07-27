package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.store.entities.TestEntity;

@RestController
@RequestMapping("/test")
public class TestController {
    private final TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("{id}")
    public String getTestById(@PathVariable Long id, TestEntity testEntity){

        return testService.get(id).getName();
    }

    @PostMapping
    public String createTest(@RequestBody TestEntity testEntity){
        try {
            testService.create(testEntity);
        } catch (Exception e){
            return e.getStackTrace().toString();
        }
        return "Test Ok";
    }
}
