package com.liinarodriguez.jwtauthapi.auth;

import com.liinarodriguez.jwtauthapi.entity.Role;
import com.liinarodriguez.jwtauthapi.entity.User;
import com.liinarodriguez.jwtauthapi.jwt.JwtService;
import com.liinarodriguez.jwtauthapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user = userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        String token = jwtService.getToken((User) user);
        return AuthResponse.builder()
                .token(token)
                .build();

    }

    public AuthResponse register(RegisterRequest request) {
      User user = User.builder()
              .username(request.getUsername())
              .password(passwordEncoder.encode( request.getPassword()))
              .role(Role.User)
              .build();
      userRepository.save(user);
      return AuthResponse.builder()
              .token(jwtService.getToken(user))
              .build();
     }
}
