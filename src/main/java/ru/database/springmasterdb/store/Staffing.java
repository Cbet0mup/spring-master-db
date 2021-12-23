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
@Table(name = "staffing")
public class Staffing {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String name;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private StaffRole staffRole;
}
