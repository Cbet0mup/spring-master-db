package ru.database.springmasterdb.factories;

import org.springframework.stereotype.Component;
import ru.database.springmasterdb.dto.EngineerDTO;

@Component
public class EngineerDTOFactory {
    public EngineerDTO createEngineerDTO(Engineer engineer) {
        return EngineerDTO.builder()
                .engineerName(engineer.getEngineerName())
                .id(engineer.getId())
                .build();
    }
}
