package ru.database.springmasterdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
@JsonIgnoreProperties({ "id" })
public class ProductNameDTO {
    private Integer id;
    private String productName;         //тип: телек, стиралка
}
