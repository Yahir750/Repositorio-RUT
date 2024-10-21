package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;


@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imageUrl; // URL de la imagen del producto
    private int stock;

}