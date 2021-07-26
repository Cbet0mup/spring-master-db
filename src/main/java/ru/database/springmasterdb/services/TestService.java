package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.store.entities.TestEntity;
import ru.database.springmasterdb.store.repositories.TestRepo;

@Service
public class TestService{
    private final TestRepo testRepo;

    public TestService(TestRepo testRepo) {
        this.testRepo = testRepo;
    }

    public void create(TestEntity testEntity){
        testRepo.save(testEntity);
    }

    public TestEntity get(Long id){

        return testRepo.findById(id).orElse(null);
    }

}
