package com.liinarodriguez.jwtauthapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    protected Integer Id;
    protected  String User;
    protected  String Role;
    protected  String Password;
}
