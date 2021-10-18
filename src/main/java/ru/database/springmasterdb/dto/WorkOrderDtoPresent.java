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
    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private String createdAt;  //дата приёмки
    private String givenOut;   //дата выдачи
    private String id;
    private String isNeedCall;            //нужем звлнок
    private String isDone;              //готов
    private String isDoneIsCalled;     // статус: готов, клиент извещён
    private String isGivenOut;          // статус: выдан
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
    private String finalPrice;   /// окончательная стоимость ремонта
    private String priceName;            //тип устройства
    private String look;                 //внешний вид
    private String complection;            //комплектация
    private String trouble;              //неисправность
}
