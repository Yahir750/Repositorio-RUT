package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;

import java.util.List;


@Data
public class OrderDTO {
    private Long id;
    private Long userId;
    private String status;
    private List<OrderItemDTO> items;
}