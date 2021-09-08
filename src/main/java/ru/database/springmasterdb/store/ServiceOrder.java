package ru.database.springmasterdb.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
//@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ServiceOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String serviceType;

    @OneToOne(mappedBy = "service", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private WorkOrder workOrder;
}
