package ru.database.springmasterdb.store;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "work_order")
//@EqualsAndHashCode(of = {"id"})
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Accessors(chain = true)
//@Data
@Getter
@Setter
public class WorkOrder implements Serializable {

    @Id
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Column(updatable = false, nullable = false)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;  //дата приёмки

    @NotEmpty(message = "Имя не должно быть пустым.")
    @Size(min = 2, max = 30, message = "Имя должно быть в диапазоне от 2 до 30 символов.")
    private String customerName;

    @NotEmpty(message = "Требуется ввести номер телефона.")
    @Size(min = 6, max = 16, message = "Неправильный размер номера.")
    private String customerPhone;

    private String serialNumber;
    private String imei;

    //private Integer price;   /// стоимость ремонта

    private Integer prepayment;   /// предоплата

    private Boolean isDone;   // статус: готов
    private Boolean isNeedCall;   // статус: связь с клиентом
    private Boolean isDoneIsCalled;   // статус: готов, клиент извещён
    private Boolean isGivenOut;   // статус: готов, клиент извещён

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOfIssue; //дата выдачи

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private ModelName model;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "price")
    private Price price;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ServiceOrder service;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "receiver_id")
    private Receiver receiver;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;

}
