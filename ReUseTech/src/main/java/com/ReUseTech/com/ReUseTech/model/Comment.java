package com.ReUseTech.com.ReUseTech.model;

import javax.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;


@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private String content;
    private Integer rating;
    private LocalDateTime createdAt;
}