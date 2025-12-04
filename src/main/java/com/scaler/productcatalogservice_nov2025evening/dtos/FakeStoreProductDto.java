package com.scaler.productcatalogservice_nov2025evening.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private String description;
    private String image;
    private String category;
    private Double price;
}
