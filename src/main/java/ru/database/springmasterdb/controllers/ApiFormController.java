package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.ManufacturerDTO;
import ru.database.springmasterdb.dto.ModelNameDTO;
import ru.database.springmasterdb.dto.ProductNameDTO;
import ru.database.springmasterdb.services.ManufacturerServiceImpl;
import ru.database.springmasterdb.services.ModelNameServiceImpl;
import ru.database.springmasterdb.services.ProductNameServiceImpl;

import java.util.List;

@RestController
@RequestMapping(path = "/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiFormController {

    private final ProductNameServiceImpl productNameService;
    private final ManufacturerServiceImpl manufacturerService;
    private final ModelNameServiceImpl modelNameService;

    @Autowired
    public ApiFormController(ProductNameServiceImpl productNameService, ManufacturerServiceImpl manufacturerService,
                             ModelNameServiceImpl modelNameService) {
        this.productNameService = productNameService;
        this.manufacturerService = manufacturerService;
        this.modelNameService = modelNameService;
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

    @PostMapping("/apiform/manufacturer")
    public ResponseEntity<ManufacturerDTO> createWorkOrder(@RequestBody ManufacturerDTO manufacturerDTO) {
        manufacturerService.createManufacturer(manufacturerDTO);
        return new ResponseEntity<>(manufacturerDTO, HttpStatus.CREATED);
    }

    //Model
    @GetMapping("/apiform/modelname/{id}")
    public ResponseEntity<List<ModelNameDTO>> getAllModelByManufacturerId(@PathVariable("id") Integer id) {
        List<ModelNameDTO> modelNameDTOList = modelNameService.findAllByManId(id);
        return new ResponseEntity<>(modelNameDTOList, HttpStatus.OK);
    }

    @PostMapping("/apiform/modelname")
    public ResponseEntity<ModelNameDTO> createWorkOrder(@RequestBody ModelNameDTO modelNameDTO) {
        modelNameService.createModelName(modelNameDTO);
        return new ResponseEntity<>(modelNameDTO, HttpStatus.CREATED);
    }
}
