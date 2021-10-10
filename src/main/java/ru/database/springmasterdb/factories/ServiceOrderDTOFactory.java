package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.ServiceOrderDTO;
import ru.database.springmasterdb.store.ServiceOrder;

@Component
public class ServiceOrderDTOFactory {
    public ServiceOrderDTO createServiceOrderDTO(ServiceOrder serviceOrder){
        return ServiceOrderDTO.builder()
                .serviceType(serviceOrder.getServiceType())
                .id(serviceOrder.getId())
                .build();
    }

}
