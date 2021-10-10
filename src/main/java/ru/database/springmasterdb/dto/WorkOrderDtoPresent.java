package ru.database.springmasterdb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkOrderDtoPresent {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;  //дата приёмки
    private LocalDateTime givenOut;   //дата выдачи
    private Integer id;
    private Boolean isNeedCall;            //нужем звлнок
    private Boolean isDone;              //готов
    private Boolean isDoneIsCalled;     // статус: готов, клиент извещён
    private Boolean isGivenOut;          // статус: готов, клиент извещён
    private String customerName;
    private String customerPhone;
    private String serialNumber;
    private String imei;
    private String serviceName;         //платный, гарантийный
    private String productName;         //тип: телек, стиралка
    private String manufacturerName;        //производитель
    private String receiverName;            //приёмщик
    private String engineerName;        //инжинер
    private String modelName;           //модель
    private String price;               //цена ремонта
    private String priceName;            //тип устройства
    private String look;                 //внешний вид
    private String complection;            //комплектация
    private String trouble;              //неисправность
}
