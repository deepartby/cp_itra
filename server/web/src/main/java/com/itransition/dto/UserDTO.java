package com.itransition.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;

    private String login;
    private String password;

    private boolean isActivated;
}