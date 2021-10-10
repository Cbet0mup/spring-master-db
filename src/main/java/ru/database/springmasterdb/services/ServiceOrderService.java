package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.ServiceOrderDTO;

import java.util.List;

public interface ServiceOrderService {
    List<ServiceOrderDTO> findAll();
    void createServiceOrder(ServiceOrderDTO serviceOrderDTO);
}
