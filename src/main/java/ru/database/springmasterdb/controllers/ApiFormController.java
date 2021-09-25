package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<List<ProductNameDTO>> getAll() {
        List<ProductNameDTO> productNameDTOList = productNameService.findAll();
        return new ResponseEntity<>(productNameDTOList, HttpStatus.OK);
    }

    @PostMapping("/apiform/productname")
    public ResponseEntity<ProductNameDTO> createWorkOrder(@RequestBody ProductNameDTO productNameDTO) {
        productNameService.createProductName(productNameDTO);
        return new ResponseEntity<>(productNameDTO, HttpStatus.CREATED);
    }
}
