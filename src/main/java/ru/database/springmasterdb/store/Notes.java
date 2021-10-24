package ru.database.springmasterdb.store;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Builder
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"ignoreUnknown = true"})
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id;
    private Integer idWorkOrder;
    private String messages;


}
