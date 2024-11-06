package com.ReUseTech.com.ReUseTech.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private String content;
    private Integer rating;
    private LocalDateTime createdAt;
}
