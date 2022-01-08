package ru.database.springmasterdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import ru.database.springmasterdb.role.StaffRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Accessors(chain = true)
public class StaffDTO {
    private String name;
    private String phoneNumber;
    private StaffRole staffRole;
}
