package com.ReUseTech.com.ReUseTech.repository;


import com.ReUseTech.com.ReUseTech.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByProductId(Long productId);
    List<Comment> findByUserId(Long userId);
}