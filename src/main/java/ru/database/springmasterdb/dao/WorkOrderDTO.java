package ru.database.springmasterdb.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
