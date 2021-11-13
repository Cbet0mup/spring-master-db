package ru.database.springmasterdb.dto;

import lombok.Data;

@Data               //статус: ожидает деталь
public class IsWaitingSparePartsDTO {
    private Integer id;
    private Boolean isWaitingForASpareParts;
}
