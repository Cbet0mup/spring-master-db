package ru.database.springmasterdb.services;


import ru.database.springmasterdb.dto.ManufacturerDTO;

import java.util.List;

public interface ManufacturerService {

    List<ManufacturerDTO> findAll();

}
