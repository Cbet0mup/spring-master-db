package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.ManufacturerDTO;
import ru.database.springmasterdb.store.Manufacturer;

@Component
public class ManufacturerDTOFactory {
    public ManufacturerDTO createManufacturerDTO(Manufacturer manufacturer){
        return ManufacturerDTO.builder()
                .id(manufacturer.getId())
                .manufacturer(manufacturer.getManufacturerName())
                .build();
    }
}
