package com.ReUseTech.product_service.model.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    private String imageUrl;
    private Long sellerId;
}