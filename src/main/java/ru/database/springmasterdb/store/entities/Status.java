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
public class Status {                   //в ремонте, готов, дозвон, принят

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String statusName;

    @OneToOne(mappedBy = "status", cascade = CascadeType.ALL)
    private WorkOrder workOrder;
}
