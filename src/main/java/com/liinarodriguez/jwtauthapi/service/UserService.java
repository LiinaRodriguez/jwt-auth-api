package com.liinarodriguez.jwtauthapi.service;

import com.liinarodriguez.jwtauthapi.entity.User;
import com.liinarodriguez.jwtauthapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Component
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public List<User> listarTodosLosUsuarios(){
        return userRepository.findAll();
    }
    //public Optional<User> findByUsername(String username){
      //  return userRepository.findByUsername(username);
    //}

}
