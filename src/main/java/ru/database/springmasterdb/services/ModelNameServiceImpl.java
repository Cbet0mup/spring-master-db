package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.ModelNameDTO;
import ru.database.springmasterdb.factories.ModelNameDTOFactory;
import ru.database.springmasterdb.store.ModelName;
import ru.database.springmasterdb.store.ModelRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelNameServiceImpl implements ModelNameService{

    ModelRepo modelRepo;
    ModelNameDTOFactory modelNameDTOFactory;

    public ModelNameServiceImpl(ModelRepo modelRepo, ModelNameDTOFactory modelNameDTOFactory) {
        this.modelRepo = modelRepo;
        this.modelNameDTOFactory = modelNameDTOFactory;
    }

    @Override
    public List<ModelNameDTO> findAll() {
        List<ModelName> modelNameList = modelRepo.getAll();
        List<ModelNameDTO> modelNameDTOList = new ArrayList<>();
        for (ModelName modelName : modelNameList){
            modelNameDTOList.add(modelNameDTOFactory.createModelNameDTO(modelName));
        }
        return modelNameDTOList;
    }

    @Override
    public List<ModelNameDTO> findAllByManId(Integer id) {
        List<ModelName> modelNameList = modelRepo.findAllByManufacturerId(id);
        List<ModelNameDTO> modelNameDTOList = new ArrayList<>();
        for (ModelName modelName : modelNameList){
            modelNameDTOList.add(modelNameDTOFactory.createModelNameDTO(modelName));
        }
        return modelNameDTOList;
    }

    @Override
    public void createModelName(ModelNameDTO modelNameDTO) {
        ModelName modelName = ModelName.builder().modelName(modelNameDTO.getModelName()).manufacturerId(modelNameDTO.getManufacturerId()).build();
        modelRepo.saveAndFlush(modelName);
    }
}
