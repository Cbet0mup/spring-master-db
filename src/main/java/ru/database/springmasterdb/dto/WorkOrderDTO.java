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

    //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;  //дата приёмки
    private LocalDateTime givenOut;   //дата выдачи
    private String customerName;        //  заказчик
    private String customerPhone;       //
    private String serialNumber;        //
    private String imei;                //
    private String look;            //внешний вид
    private String complection;            //комплектация
    private String trouble;            //неисправность
    private String finalPrice;   /// окончательная стоимость ремонта
    private Boolean isNeedCall;   // звонок нужен
    private Boolean isDone;   //готов
    private Boolean isDoneIsCalled;   // статус: готов, клиент извещён
    private Boolean isGivenOut;   // статус: выдан
    private Boolean isAccepted;   // статус: принят
    private Integer modelId;       //  модель
    private Integer serviceId;     //платный, гарантийный
    private Integer productId;             //тип: телек, стиралка краткий
    private Integer manufacturerId;        //марка: производитель
    private Integer receiverId;        //приёмщик
    private Integer engineerId;        //мастер
    private Integer statusId;          //принят, выдан, на звонке
    private Integer priceId;           //прайс, тип устройства подробный и цена

}
