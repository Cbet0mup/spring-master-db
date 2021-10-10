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
@DynamicInsert
@DynamicUpdate
@JsonIgnoreProperties({"ignoreUnknown = true"})
@Accessors(chain = true)
@Getter
@Setter
public class WorkOrder implements Serializable {

    @Id
    @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Column(updatable = false, nullable = false)
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime createdAt;  //дата приёмки

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime givenOut;  //дата выдачи

    @NotEmpty(message = "Имя не должно быть пустым.")
    private String customerName;

    @NotEmpty(message = "Требуется ввести номер телефона.")
    private String customerPhone;

    private String serialNumber;
    private String imei;

    private String look;            //внешний вид
    private String complection;            //комплектация
    private String trouble;            //неисправность

    private Integer prepayment;   /// предоплата

    private Boolean isDone;   // статус: готов
    private Boolean isNeedCall;   // статус: связь с клиентом
    private Boolean isDoneIsCalled;   // статус: готов, клиент извещён
    private Boolean isGivenOut;   // статус: готов, клиент извещён

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dateOfIssue; //дата выдачи

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "model_id")
    private ModelName model;            //модель аппарата

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "price")
    private Price price;                //базовая стоимость ремонта

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "service_id")
    private ServiceOrder service;           //платный, гарантийный

    @OneToOne(fetch=FetchType.LAZY)
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
