package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class ReceiverDTO {
    private Integer id;
    private String ReceiverName;
}
