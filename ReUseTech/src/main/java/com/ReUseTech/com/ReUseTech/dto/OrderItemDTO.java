package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;


@Data
public class OrderItemDTO {
    private Long id;
    private Long productId;
    private int quantity;
}