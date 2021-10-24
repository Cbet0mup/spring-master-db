package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class NotesDTO {
    private Integer id;
    private Integer idWorkOrder;
    private String messages;
}
