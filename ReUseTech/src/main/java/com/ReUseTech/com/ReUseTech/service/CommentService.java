package com.ReUseTech.com.ReUseTech.service;


import com.ReUseTech.com.ReUseTech.dto.CommentDTO;
import com.ReUseTech.com.ReUseTech.exception.ResourceNotFoundException;
import com.ReUseTech.com.ReUseTech.mapper.CommentMapper;
import com.ReUseTech.com.ReUseTech.model.Comment;
import com.ReUseTech.com.ReUseTech.model.Product;
import com.ReUseTech.com.ReUseTech.model.User;
import com.ReUseTech.com.ReUseTech.repository.CommentRepository;
import com.ReUseTech.com.ReUseTech.repository.ProductRepository;
import com.ReUseTech.com.ReUseTech.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    public CommentDTO addComment(Long productId, Long userId, CommentDTO commentDTO){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setProduct(product);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDTO(savedComment);

    }

    public List<CommentDTO> getCommentsByProduct(Long productId){
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(commentMapper::toDTO)
                .collect(Collectors.toList());
    }

}