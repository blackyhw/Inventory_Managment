package com.gestionador.inventory_management.model.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
}
