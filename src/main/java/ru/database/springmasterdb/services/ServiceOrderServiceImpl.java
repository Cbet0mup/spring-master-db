package ru.database.springmasterdb.services;

import org.springframework.stereotype.Service;
import ru.database.springmasterdb.dto.ServiceOrderDTO;
import ru.database.springmasterdb.factories.ServiceOrderDTOFactory;
import ru.database.springmasterdb.store.ServiceOrder;
import ru.database.springmasterdb.store.ServiceOrderRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceOrderServiceImpl implements ServiceOrderService{

    ServiceOrderRepo serviceOrderRepo;
    ServiceOrderDTOFactory serviceOrderDTOFactory;

    public ServiceOrderServiceImpl(ServiceOrderRepo serviceOrderRepo, ServiceOrderDTOFactory serviceOrderDTOFactory) {
        this.serviceOrderRepo = serviceOrderRepo;
        this.serviceOrderDTOFactory = serviceOrderDTOFactory;
    }

    @Override
    public List<ServiceOrderDTO> findAll() {
        List<ServiceOrder> serviceOrderList = serviceOrderRepo.getAll();
        List<ServiceOrderDTO> serviceOrderDTOList = new ArrayList<>();

        for(ServiceOrder serviceOrder : serviceOrderList){
            serviceOrderDTOList.add(serviceOrderDTOFactory.createServiceOrderDTO(serviceOrder));
        }
        return serviceOrderDTOList;
    }

    @Override
    public void createServiceOrder(ServiceOrderDTO serviceOrderDTO) {
            ServiceOrder serviceOrder = ServiceOrder.builder().serviceType(serviceOrderDTO.getServiceType().trim()).build();
            serviceOrderRepo.saveAndFlush(serviceOrder);
    }
}
