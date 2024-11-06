
package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class CartDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
    private LocalDateTime createdAt;
}