package ru.database.springmasterdb.services;

import ru.database.springmasterdb.dto.ProductNameDTO;

import java.util.List;

public interface ProductNameService {
    List<ProductNameDTO> findAll();
    void createProductName(ProductNameDTO productNameDTO);
}
