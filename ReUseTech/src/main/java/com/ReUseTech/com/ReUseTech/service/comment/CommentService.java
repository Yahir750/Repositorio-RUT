
package com.ReUseTech.com.ReUseTech.service.comment;


import com.ReUseTech.com.ReUseTech.dto.CommentDTO;
import com.ReUseTech.com.ReUseTech.mapper.CommentMapper;
import com.ReUseTech.com.ReUseTech.model.Comment;
import com.ReUseTech.com.ReUseTech.model.Product;
import com.ReUseTech.com.ReUseTech.model.User;
import com.ReUseTech.com.ReUseTech.repository.CommentRepository;
import com.ReUseTech.com.ReUseTech.repository.ProductRepository;
import com.ReUseTech.com.ReUseTech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    public List<CommentDTO> getProductComments(Long productId) {
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(CommentMapper.INSTANCE::toCommentDTO)
                .collect(Collectors.toList());
    }

    public CommentDTO addComment(CommentDTO commentDTO) {
        User user = userRepository.findById(commentDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(commentDTO.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Comment comment = CommentMapper.INSTANCE.toComment(commentDTO);
        comment.setUser(user);
        comment.setProduct(product);
        comment.setCreatedAt(LocalDateTime.now());

        comment = commentRepository.save(comment);
        return CommentMapper.INSTANCE.toCommentDTO(comment);
    }
}