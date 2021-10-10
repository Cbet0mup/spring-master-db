package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class ServiceOrderDTO {

    private Integer id;
    private String serviceType;  //платный, гарантийный
}
