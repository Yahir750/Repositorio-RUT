package com.ReUseTech.com.ReUseTech.model;


import javax.persistence.*;
import lombok.Data;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long productId;
    private String content;

    // Otros campos que consideres necesarios
}