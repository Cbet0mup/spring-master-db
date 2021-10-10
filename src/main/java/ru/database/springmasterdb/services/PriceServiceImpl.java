package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.PriceDTO;
import ru.database.springmasterdb.factories.PriceDTOFactory;
import ru.database.springmasterdb.store.Price;
import ru.database.springmasterdb.store.PriceRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService{

    PriceRepo priceRepo;
    PriceDTOFactory priceDTOFactory;

    public PriceServiceImpl(PriceRepo priceRepo, PriceDTOFactory priceDTOFactory) {
        this.priceRepo = priceRepo;
        this.priceDTOFactory = priceDTOFactory;
    }

    @Override
    public List<PriceDTO> findAllByProductId(Integer id) {
        List<Price> priceList = priceRepo.findAllByProductId(id);
        List<PriceDTO> priceDTOList = new ArrayList<>();

        for(Price price : priceList){
            priceDTOList.add(priceDTOFactory.createPriceDTO(price));
        }
        return priceDTOList;
    }

    @Override
    public void createPrice(PriceDTO priceDTO) {
        Price price = Price.builder()
                .priceName(priceDTO.getPriceName())
                .price(priceDTO.getPrice())
                .productId(priceDTO.getProductId())
                .build();
        priceRepo.saveAndFlush(price);
    }
}
