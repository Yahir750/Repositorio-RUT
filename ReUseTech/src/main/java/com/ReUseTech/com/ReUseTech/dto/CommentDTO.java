package com.ReUseTech.com.ReUseTech.dto;

import lombok.Getter;

@Getter
public class CommentDTO {
    private Long id;
    private Long productId;
    private String content;

    // Getters y setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
