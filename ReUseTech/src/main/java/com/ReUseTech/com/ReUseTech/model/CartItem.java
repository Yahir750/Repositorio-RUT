package com.ReUseTech.com.ReUseTech.model;

import javax.persistence.*;
import lombok.Data;


@Entity
@Data
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Long productId;
    private int quantity;

    // Otros campos que consideres necesarios
}