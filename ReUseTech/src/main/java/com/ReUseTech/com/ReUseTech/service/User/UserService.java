package com.ReUseTech.com.ReUseTech.service.User;

import com.ReUseTech.com.ReUseTech.dto.UserDTO;
import com.ReUseTech.com.ReUseTech.mapper.UserMapper;
import com.ReUseTech.com.ReUseTech.model.User;
import com.ReUseTech.com.ReUseTech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.INSTANCE.toUserDTO(user);
    }

    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserMapper.INSTANCE::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.INSTANCE.toUser(userDTO);
        user = userRepository.save(user);
        return UserMapper.INSTANCE.toUserDTO(user);
    }
}