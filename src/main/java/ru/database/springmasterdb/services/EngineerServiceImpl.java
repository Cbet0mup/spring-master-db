package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.EngineerDTO;
import ru.database.springmasterdb.factories.EngineerDTOFactory;
import ru.database.springmasterdb.store.Engineer;
import ru.database.springmasterdb.store.EngineerRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class EngineerServiceImpl implements EngineerService{
    EngineerRepo engineerRepo;
    EngineerDTOFactory engineerDTOFactory;

    public EngineerServiceImpl(EngineerRepo engineerRepo, EngineerDTOFactory engineerDTOFactory) {
        this.engineerRepo = engineerRepo;
        this.engineerDTOFactory = engineerDTOFactory;
    }


    @Override
    public List<EngineerDTO> findAll() {
        List<Engineer> engineerList = engineerRepo.getAll();
        List<EngineerDTO> engineerDTOList = new ArrayList<>();
        for (Engineer engineer : engineerList){
            engineerDTOList.add(engineerDTOFactory.createEngineerDTO(engineer));
        }
        return engineerDTOList;
    }

    @Override
    public void createNewEngineer(EngineerDTO engineerDTO) {
        Engineer engineer = Engineer.builder().engineerName(engineerDTO.getEngineerName()).build();
        engineerRepo.saveAndFlush(engineer);
    }
}
