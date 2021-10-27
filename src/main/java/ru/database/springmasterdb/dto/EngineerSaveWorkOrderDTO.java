package ru.database.springmasterdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EngineerSaveWorkOrderDTO {
    private Integer id;
    private String troubleDetected;            //выявленная неисправность
    private String troubleSolving;            //описание работ
}
