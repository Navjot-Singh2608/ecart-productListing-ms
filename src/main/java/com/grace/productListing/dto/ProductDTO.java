package com.grace.productListing.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int id;
    private String sku;
    private String name;
    private String description;
    private String ratings;
    private String price;
    private String category;
    private String brand;
    private String reviewCount;
    private String imageUrl;
    private Integer quantity;

}