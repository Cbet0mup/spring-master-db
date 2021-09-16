package ru.database.springmasterdb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class WorkOrderDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;  //дата приёмки
    private LocalDateTime givenOut;   //дата выдачи
    private String customerName;        //  заказчик
    private String customerPhone;       //
    private String serialNumber;        //
    private String imei;                //
    private String look;            //внешний вид
    private String complection;            //комплектация
    private String trouble;            //неисправность
    private Boolean isNeedCall;   // звонок нужен
    private Boolean isDone;   //готов
    private Boolean isDoneIsCalled;   // статус: готов, клиент извещён
    private Boolean isGivenOut;   // статус: готов, клиент извещён
    private Long modelId;       //  модель
    private Long serviceId;     //платный, гарантийный
    private Long productId;             //тип: телек, стиралка
    private Long manufacturerId;        //марка: производитель
    private Long receiverId;        //приёмщик
    private Long engineerId;        //мастер
    private Long statusId;          //принят, выдан, на звонке
    private Long priceId;           //прайс, тип устройства и цена

}
