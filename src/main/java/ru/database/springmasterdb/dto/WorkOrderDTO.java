package ru.database.springmasterdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkOrderDTO {

    private String customerName;
    private String customerPhone;
    private String serialNumber;
    private Long serviceId;
    private Long productId;
    private Long manufacturerId;
    private Long receiverId;
    private Long engineerId;
    private Long statusId;

}
