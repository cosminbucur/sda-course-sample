package com.sda.spring.data.jpa.mapper;

import com.sda.spring.data.jpa.dto.UserDto;
import com.sda.spring.data.jpa.validation.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<User> toEntity(List<UserDto> dtos) {
        return dtos.stream()
                .map(userDto -> toEntity(userDto))
                .collect(Collectors.toList());
    }

    public static List<UserDto> toDto(List<User> users) {
        return users.stream()
                .map(user -> toDto(user))
                .collect(Collectors.toList());
    }

    public static User toEntity(UserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        return user;
    }

    public static UserDto toDto(User user) {
        UserDto dto = new UserDto();
        dto.setName(dto.getName());
        dto.setEmail(dto.getEmail());
        return dto;
    }
}
