package com.ReUseTech.com.ReUseTech.mapper;

import com.ReUseTech.com.ReUseTech.dto.UserDTO;
import com.ReUseTech.com.ReUseTech.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CommentMapper.class, OrderMapper.class})
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toUserDTO(User user);

    User toUser(UserDTO userDTO);
}
