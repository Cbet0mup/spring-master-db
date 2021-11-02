package ru.database.springmasterdb.dto;

import lombok.Data;

//статус наряда isDone готов/true - в работе/false мастером
@Data
public class IsDoneDTO {
    private Integer id;
    private Boolean isDone;
}
