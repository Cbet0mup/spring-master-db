package ru.database.springmasterdb.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;
import ru.database.springmasterdb.role.StaffRole;

import javax.persistence.*;

@Builder
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"ignoreUnknown = true"})
public class Staffing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String engineerName;
    private String phoneNumber;

    @Enumerated(EnumType.ORDINAL)
    private StaffRole staffRole;
}
