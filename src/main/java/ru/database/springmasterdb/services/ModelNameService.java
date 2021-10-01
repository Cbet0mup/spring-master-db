package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.ModelNameDTO;
import java.util.List;

public interface ModelNameService {
    List<ModelNameDTO> findAll();
    List<ModelNameDTO> findAllByManId(Integer id);
    void createModelName(ModelNameDTO modelNameDTO);
}
