package ru.database.springmasterdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class ModelNameDTO {

    @JsonIgnore
    private Integer id;
    private Integer manufacturerId;
    private String modelName;         //sm-a305
}
