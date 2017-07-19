package com.itransition.converter;

import com.itransition.dto.UserDTO;
import com.itransition.entity.User;

public class UserConverter {
    public static User convert(UserDTO dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setName(dto.getName());
        user.setSurname(dto.getSurname());
        user.setEmail(dto.getEmail());

        user.setLogin(dto.getLogin());
        user.setPassword(dto.getPassword());

        user.setIsActivated(dto.isActivated());
        return user;
    }

    public static UserDTO convert(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setSurname(user.getSurname());
        dto.setEmail(user.getEmail());

        dto.setLogin(user.getLogin());
        dto.setPassword(user.getPassword());

        dto.setActivated(user.getIsActivated());
        return dto;
    }
}
