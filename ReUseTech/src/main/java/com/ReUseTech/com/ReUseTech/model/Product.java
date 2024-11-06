package com.ReUseTech.com.ReUseTech.model;


import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl; // URL de la imagen del producto
    private int stock;
}