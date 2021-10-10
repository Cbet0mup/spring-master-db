package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.PriceDTO;
import ru.database.springmasterdb.store.Price;

@Component
public class PriceDTOFactory {
    public PriceDTO createPriceDTO(Price price){
        return PriceDTO.builder()
                .priceName(price.getPriceName())
                .price(price.getPrice())
                .productId(price.getProductId())
                .id(price.getId())
                .build();
    }
}
