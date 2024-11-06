package com.ReUseTech.com.ReUseTech.mapper;

import com.ReUseTech.com.ReUseTech.dto.CommentDTO;
import com.ReUseTech.com.ReUseTech.model.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {
    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    CommentDTO toCommentDTO(Comment comment);
    Comment toComment(CommentDTO commentDTO);
}
