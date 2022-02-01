package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.StaffDTO;
import ru.database.springmasterdb.factories.StaffDTOFactory;
import ru.database.springmasterdb.store.StaffingRepo;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService{
    private final StaffDTOFactory staffDTOFactory;
    private final StaffingRepo staffingRepo;

    public StaffServiceImpl(StaffDTOFactory staffDTOFactory, StaffingRepo staffingRepo) {
        this.staffDTOFactory = staffDTOFactory;
        this.staffingRepo = staffingRepo;
    }


    public List<StaffDTO> getAllEngineers() {
        return null;
    }
}
