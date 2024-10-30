
package com.ReUseTech.com.ReUseTech.service.comment;


import com.ReUseTech.com.ReUseTech.dto.CommentDTO;
import com.ReUseTech.com.ReUseTech.mapper.CommentMapper;
import com.ReUseTech.com.ReUseTech.model.Comment;
import com.ReUseTech.com.ReUseTech.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public CommentDTO getComment(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        return CommentMapper.INSTANCE.toCommentDTO(comment);
    }

    public List<CommentDTO> getCommentsByProduct(Long productId) {
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(CommentMapper.INSTANCE::toCommentDTO)
                .collect(Collectors.toList());
    }

    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = CommentMapper.INSTANCE.toComment(commentDTO);
        comment = commentRepository.save(comment);
        return CommentMapper.INSTANCE.toCommentDTO(comment);
    }

    public CommentDTO addComment(Long productId, Long userId, @Valid CommentDTO commentDTO) {
        return null;
    }
}
