package com.liinarodriguez.jwtauthapi.controller;

import com.liinarodriguez.jwtauthapi.entity.User;
import com.liinarodriguez.jwtauthapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping(value="demo")
    public String welcome(){
        return "Welcome from a secure endpoint";
    }

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public List<User> listarUsuarios(){
        return userService.listarTodosLosUsuarios();
    }
}
