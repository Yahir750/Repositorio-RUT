package com.ReUseTech.com.ReUseTech.dto;


import javax.validation.constraints.Positive;
import lombok.Data;

@Data
public class CartItemDTO {
    private Long id;
    private Long productId;
    private int quantity;

    // Otros campos que consideres necesarios
}