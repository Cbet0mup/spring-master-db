package ru.database.springmasterdb.dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkOrderDtoPresent {
    private String createdAt;  //дата приёмки
    private String givenOut;   //дата выдачи  клиенту на руки
    private String dateOfIssue;  //дата выдачи инженером

    private Integer id;
    private Boolean isNeedCall;            //нужем звлнок
    private Boolean isDone;              //готов
    private Boolean isDoneIsCalled;     // статус: готов, клиент извещён
    private Boolean isGivenOut;          // статус: выдан
    private Boolean isAccepted;   // статус: принят

    private String customerName;
    private String customerPhone;

    private String chatLog;         //примечания

    private String serialNumber;
    private String imei;
    private String serviceName;         //платный, гарантийный
    private String productName;         //тип: телек, стиралка
    private String manufacturerName;        //производитель
    private String receiverName;            //приёмщик
    private String engineerName;        //инжинер
    private String modelName;           //модель
    private String priceName;            //тип устройства

    private String prepayment;          //предоплата
    private String price;               //цена ремонта
    private String finalPrice;   /// окончательная стоимость ремонта
    private String additionalPrice;   ///стоимость доп работ и деталей

    private String look;                 //внешний вид
    private String complection;            //комплектация
    private String trouble;              //неисправность со слов
    private String troubleDetected;            //выявленная неисправность
    private String troubleSolving;            //описание работ

    private Integer priceId;           //прайс, тип устройства подробный и цена
    private Integer modelId;       //  модель
    private Integer serviceId;     //платный, гарантийный
    private Integer productId;             //тип: телек, стиралка краткий
    private Integer manufacturerId;        //марка: производитель
    private Integer receiverId;        //приёмщик
    private Integer engineerId;        //мастер
    private Integer statusId;          //принят, выдан, на звонке

}
