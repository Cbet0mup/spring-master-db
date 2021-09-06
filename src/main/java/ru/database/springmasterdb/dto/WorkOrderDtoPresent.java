package ru.database.springmasterdb.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkOrderDtoPresent {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime createdAt;  //дата приёмки
    private String customerName;
    private String customerPhone;
    private String serialNumber;
    private String serviceName;
    private String productName;
    private String manufacturerName;
    private String receiverName;
    private String engineerName;
}
