package ru.database.springmasterdb.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Builder
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"ignoreUnknown = true"})
public class ModelName implements Serializable {            //модель
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;

    private String modelName;

    private Integer manufacturerId;

}
