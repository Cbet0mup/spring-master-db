package ru.database.springmasterdb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class WorkOrderDTO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;  //дата приёмки
    private String customerName;
    private String customerPhone;
    private String serialNumber;
    private Long modelId;
    private Long serviceId;
    private Long productId;
    private Long manufacturerId;
    private Long receiverId;
    private Long engineerId;
    private Long statusId;

}
