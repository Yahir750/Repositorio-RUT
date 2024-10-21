package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private String content;

}