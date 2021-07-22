package ru.database.springmasterdb.store.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.apache.juli.WebappProperties;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manufacturer {                 //производитель
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    private String manufacturerName;

    @OneToOne(mappedBy = "manufacturer", cascade = CascadeType.ALL)
    private WorkOrder workOrder;

}
