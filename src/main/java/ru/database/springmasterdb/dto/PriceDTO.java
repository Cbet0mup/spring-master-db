package ru.database.springmasterdb.dto;

import lombok.*;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Accessors(chain = true)
public class PriceDTO {

    private Integer id;
    private Integer productId;      ////отношение к краткому обобщённому типу
    private String price;           //цена ремонта
    private String priceName;       //  если телевизор то например - 55' жидкокристаллический
}
