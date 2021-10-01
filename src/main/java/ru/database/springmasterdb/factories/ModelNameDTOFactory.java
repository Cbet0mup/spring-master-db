package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.ModelNameDTO;
import ru.database.springmasterdb.store.ModelName;

@Component
public class ModelNameDTOFactory {
    public ModelNameDTO createModelNameDTO(ModelName modelName){
        return ModelNameDTO.builder()
                .id(modelName.getId())
                .modelName(modelName.getModelName())
                .manufacturerId(modelName.getManufacturer().getId())
                .build();
    }
}
