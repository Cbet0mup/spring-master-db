package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.ManufacturerDTO;
import ru.database.springmasterdb.dto.ProductNameDTO;
import ru.database.springmasterdb.services.ManufacturerServiceImpl;
import ru.database.springmasterdb.services.ProductNameServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiFormController {

    private final ProductNameServiceImpl productNameService;
    private final ManufacturerServiceImpl manufacturerService;

    @Autowired
    public ApiFormController(ProductNameServiceImpl productNameService, ManufacturerServiceImpl manufacturerService) {
        this.productNameService = productNameService;
        this.manufacturerService = manufacturerService;
    }
                                        // ProductName
    @GetMapping("/apiform/productname")
    public ResponseEntity<List<ProductNameDTO>> getAllProductName() {
        List<ProductNameDTO> productNameDTOList = productNameService.findAll();
        return new ResponseEntity<>(productNameDTOList, HttpStatus.OK);
    }

    @PostMapping("/apiform/productname")
    public ResponseEntity<ProductNameDTO> createWorkOrder(@RequestBody ProductNameDTO productNameDTO) {
        productNameService.createProductName(productNameDTO);
        return new ResponseEntity<>(productNameDTO, HttpStatus.CREATED);
    }

                                    //Manufacturer

    @GetMapping("/apiform/manufacturer")
    public ResponseEntity<List<ManufacturerDTO>> getAllManufacturer() {
        List<ManufacturerDTO> manufacturerDTOList = manufacturerService.findAll();
        return new ResponseEntity<>(manufacturerDTOList, HttpStatus.OK);
    }
}
