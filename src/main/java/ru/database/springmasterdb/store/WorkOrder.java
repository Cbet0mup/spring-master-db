package ru.database.springmasterdb.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;

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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(updatable = false, nullable = false)
    private Integer id;

    private String createdAt;  //дата приёмки
    private String givenOut;  //дата выдачи клиенту на руки
    private String dateOfIssue; //дата выдачи инженером

    private String customerName;
    private String customerPhone;
    private String engineerName;        //мастер
    private String receiverName;        //приёмщик

    private String serialNumber;
    private String imei;

    private String chatLog;         //примечания

    private String look;            //внешний вид
    private String complection;            //комплектация

    private String trouble;            //неисправность
    private String troubleDetected;            //выявленная неисправность
    private String troubleSolving;            //описание работ

    private String prepayment;   /// предоплата
    private String finalPrice;   /// окончательная стоимость ремонта
    private String additionalPrice;   ///стоимость доп работ и деталей

    private Boolean isDone;   // статус: готов
    private Boolean isNeedCall;   // статус: связь с клиентом
    private Boolean isDoneIsCalled;   // статус: готов, клиент извещён
    private Boolean isWaitingForASpareParts;   // статус: ожидает деталь
    private Boolean isGivenOut;   // статус: выдан
    private Boolean isAccepted;   // статус: принят и назначен мастер

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
    private Product product;                    //тип: телек, стиралка краткий

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;          //марка: производитель

//    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name = "receiver_id")
//    private Receiver receiver;                      //приёмщик

//    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    @JoinColumn(name = "engineer_id")
//    private Engineer engineer;                                   //мастер

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private Status status;                                      //принят, выдан, на звонке

    public void setChatLog(String chatLog) {
        this.chatLog += chatLog;
    }
}
