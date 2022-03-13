package com.company.mupstructspringboot.dto;

import lombok.*;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    @Id
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private long price;
}
