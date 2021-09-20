package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.database.springmasterdb.dto.ProductNameDTO;
import ru.database.springmasterdb.services.ProductNameServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiFormController {

    private final ProductNameServiceImpl productNameService;

    @Autowired
    public ApiFormController(ProductNameServiceImpl productNameService) {
        this.productNameService = productNameService;
    }

    @GetMapping("/apiform/productname")
    public ResponseEntity<List<ProductNameDTO>> getAll(){
        List<ProductNameDTO> productNameDTOList = productNameService.findAll();
        return new ResponseEntity<>(productNameDTOList, HttpStatus.OK);
    }
}
