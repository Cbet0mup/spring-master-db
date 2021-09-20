package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.ProductNameDTO;
import ru.database.springmasterdb.store.Product;

@Component
public class ProductNameDTOFactory {
    public ProductNameDTO createProductNameDTO (Product product){
        return ProductNameDTO.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .build();
    }
}
