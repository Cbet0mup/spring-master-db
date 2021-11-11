package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class WorkOrderDTO {

    private Integer id;
    private String createdAt;  //дата приёмки
    private String givenOut;   //дата выдачи
    private String dateOfIssue; //дата выдачи инженером

    private String customerName;        //  заказчик
    private String customerPhone;       //

    private String serialNumber;        //
    private String imei;                //
    private String look;            //внешний вид
    private String complection;            //комплектация

    private String chatLog;         //примечания

    private String trouble;            //неисправность со слов клиента
    private String troubleDetected;            //выявленная неисправность
    private String troubleSolving;            //описание работ

    private String finalPrice;   /// окончательная стоимость ремонта
    private String prepayment;          //предоплата
    private String additionalPrice;   ///стоимость доп работ и деталей

    private Boolean isNeedCall;   // звонок нужен
    private Boolean isDone;   //готов
    private Boolean isDoneIsCalled;   // статус: готов, клиент извещён
    private Boolean isGivenOut;   // статус: выдан
    private Boolean isAccepted;   // статус: принят
    private Boolean isWaitingForASpareParts;   // статус: ожидает деталь

    private Integer priceId;           //прайс, тип устройства подробный и цена
    private Integer modelId;       //  модель
    private Integer serviceId;     //платный, гарантийный
    private Integer productId;             //тип: телек, стиралка краткий
    private Integer manufacturerId;        //марка: производитель
    private Integer receiverId;        //приёмщик
    private Integer engineerId;        //мастер
    private Integer statusId;          //принят, выдан, на звонке
    //30

}
