package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.StaffDTO;
import ru.database.springmasterdb.store.Staffing;

@Component
public class StaffDTOFactory {
    public StaffDTO createStaffDTO(Staffing staffing) {
        return StaffDTO.builder()
                .name(staffing.getName())
                .phoneNumber(staffing.getPhoneNumber())
                .staffRole(staffing.getStaffRole())
                .build();
    }
}
