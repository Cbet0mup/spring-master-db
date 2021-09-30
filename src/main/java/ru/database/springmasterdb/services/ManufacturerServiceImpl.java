package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.ManufacturerDTO;
import ru.database.springmasterdb.factories.ManufacturerDTOFactory;
import ru.database.springmasterdb.store.Manufacturer;
import ru.database.springmasterdb.store.ManufacturerRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    ManufacturerRepo manufacturerRepo;
    ManufacturerDTOFactory manufacturerDTOFactory;

    public ManufacturerServiceImpl(ManufacturerRepo manufacturerRepo, ManufacturerDTOFactory manufacturerDTOFactory) {
        this.manufacturerRepo = manufacturerRepo;
        this.manufacturerDTOFactory = manufacturerDTOFactory;
    }

    @Override
    public List<ManufacturerDTO> findAll() {
        List<Manufacturer> manufacturerList = manufacturerRepo.findAll();
        List<ManufacturerDTO> manufacturerDTOList = new ArrayList<>();
        for (Manufacturer m : manufacturerList) {
            manufacturerDTOList.add(manufacturerDTOFactory.createManufacturerDTO(m));
        }
        return manufacturerDTOList;
    }

    @Override
    public void createManufacturer(ManufacturerDTO manufacturerDTO) {
        Manufacturer manufacturer = Manufacturer.builder().manufacturerName(manufacturerDTO.getManufacturer()).build();
        manufacturerRepo.saveAndFlush(manufacturer);
    }
}
