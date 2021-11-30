package ru.database.springmasterdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.database.springmasterdb.dto.*;
import ru.database.springmasterdb.services.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/workorder", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiFormController {

    private final ProductNameServiceImpl productNameService;
    private final ManufacturerServiceImpl manufacturerService;
    private final ModelNameServiceImpl modelNameService;
    private final PriceServiceImpl priceService;
    private final ServiceOrderServiceImpl serviceOrderService;
    private final EngineerServiceImpl engineerService;

    @Autowired
    public ApiFormController(ProductNameServiceImpl productNameService, ManufacturerServiceImpl manufacturerService,
                             ModelNameServiceImpl modelNameService, PriceServiceImpl priceService, ServiceOrderServiceImpl serviceOrderService, EngineerServiceImpl engineerService) {
        this.productNameService = productNameService;
        this.manufacturerService = manufacturerService;
        this.modelNameService = modelNameService;
        this.priceService = priceService;
        this.serviceOrderService = serviceOrderService;
        this.engineerService = engineerService;
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

    //Price
    @GetMapping("/apiform/price/{productId}")
    public ResponseEntity<List<PriceDTO>> getAllPrice(@PathVariable("productId") Integer id) {
        List<PriceDTO> priceDTOList = priceService.findAllByProductId(id);
        return new ResponseEntity<>(priceDTOList, HttpStatus.OK);
    }

    @PostMapping("/apiform/price")
    public ResponseEntity<PriceDTO> createWorkOrder(@RequestBody PriceDTO priceDTO) {
        priceService.createPrice(priceDTO);
        return new ResponseEntity<>(priceDTO, HttpStatus.CREATED);
    }

    //ServiceOrder

    @GetMapping("/apiform/service")
    public ResponseEntity<List<ServiceOrderDTO>> getAllServiceOrders() {
        List<ServiceOrderDTO> serviceOrderDTOList = serviceOrderService.findAll();
        return new ResponseEntity<>(serviceOrderDTOList, HttpStatus.OK);
    }

    @PostMapping("/apiform/service")
    public ResponseEntity<ServiceOrderDTO> createWorkOrder(@RequestBody ServiceOrderDTO serviceOrderDTO) {
        serviceOrderService.createServiceOrder(serviceOrderDTO);
        return new ResponseEntity<>(serviceOrderDTO, HttpStatus.CREATED);
    }

    //Engineer

    @GetMapping("/apiform/engineer")
    public ResponseEntity<List<EngineerDTO>> getAllEngineers() {
        List<EngineerDTO> engineerDTOList = engineerService.findAll();
        return new ResponseEntity<>(engineerDTOList, HttpStatus.OK);
    }

    @PostMapping("/apiform/engineer")
    public ResponseEntity<EngineerDTO> createWorkOrder(@RequestBody EngineerDTO engineerDTO) {
        engineerService.createNewEngineer(engineerDTO);
        return new ResponseEntity<>(engineerDTO, HttpStatus.CREATED);
    }

    //NOTES
//    @GetMapping("/apiform/notes/{id}")
//    public ResponseEntity<NotesDTO> getNotes(@PathVariable Integer id) {
//        NotesDTO notesDTO = notesService.getNotes(id);
//        return new ResponseEntity<>(notesDTO, HttpStatus.OK);
//    }
}
