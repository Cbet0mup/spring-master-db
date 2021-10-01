package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class ModelNameDTO {
    private Integer id;
    private Integer manufacturerId;
    private String modelName;         //sm-a305
}
