package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class ProductNameDTO {
    private Integer id;
    private String productName;         //тип: телек, стиралка
}
