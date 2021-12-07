package ru.database.springmasterdb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.ProductNameDTO;
import ru.database.springmasterdb.factories.ProductNameDTOFactory;
import ru.database.springmasterdb.store.Product;
import ru.database.springmasterdb.store.ProductRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductNameServiceImpl implements ProductNameService{

    private final ProductRepo productRepo;
    private final ProductNameDTOFactory productRepoDTOFact;

    @Autowired
    public ProductNameServiceImpl(ProductRepo productRepo, ProductNameDTOFactory productRepoDTOFact) {
        this.productRepo = productRepo;
        this.productRepoDTOFact = productRepoDTOFact;
    }

    @Override
    public List<ProductNameDTO> findAll() {
        List<Product> productList = productRepo.getAll();
        List<ProductNameDTO> productNameDTOList = new ArrayList<>();

        for (Product product : productList){
            productNameDTOList.add(productRepoDTOFact.createProductNameDTO(product));
        }
        return productNameDTOList;
    }

    @Override
    public void createProductName(ProductNameDTO productNameDTO) {
        Product product = Product.builder().productName(productNameDTO.getProductName().trim()).build();
        productRepo.saveAndFlush(product);
    }
}
