package com.my.quiz.service;

import com.my.quiz.dto.UserDto;
import com.my.quiz.entity.UserEntity;
import com.my.quiz.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void saveUser(UserDto dto) {
        userRepository.save(UserDto.toDto(dto));
    }
    public List<UserDto> findAllUser() {
        return userRepository.findAll().stream().map(UserDto::fromEntity).toList();
    }
    public void deleteUser(String email) {
        userRepository.deleteById(email);
    }

    public UserDto findOneUser(String email) {
        UserEntity entity = userRepository.findById(email).orElse(null);
        return ObjectUtils.isEmpty(entity) ? null : UserDto.fromEntity(entity);
    }




}
