package ru.database.springmasterdb.store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engineer {             ///master

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String engineerName;

    @OneToOne(mappedBy = "engineer", cascade = CascadeType.ALL)
    private WorkOrder workOrder;


}
