package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.EngineerDTO;

import java.util.List;

public interface EngineerService {
    List<EngineerDTO> findAll();
    void createNewEngineer(EngineerDTO engineerDTO);
}
