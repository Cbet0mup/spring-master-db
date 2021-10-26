package ru.database.springmasterdb.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatLogDTO {
    private Integer id;
    private String chatLog;
}
