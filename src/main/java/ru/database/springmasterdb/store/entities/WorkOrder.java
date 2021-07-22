package ru.database.springmasterdb.store.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_order")
public class WorkOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Builder.Default
    @NonNull
    private Instant createdAt = Instant.now();  //дата приёмки

    @NonNull
    private String customerName;
    private String customerPhone;
    private String serialNumber;
    private Instant dateOfIssue; //дата выдачи

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id")
    private Service service;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

}
