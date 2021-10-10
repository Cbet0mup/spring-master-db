package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.PriceDTO;

import java.util.List;

public interface PriceService {
    List<PriceDTO> findAllByProductId(Integer id);
    void createPrice(PriceDTO priceDTO);
}
