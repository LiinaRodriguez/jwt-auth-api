package com.liinarodriguez.jwtauthapi.jwt;

import com.liinarodriguez.jwtauthapi.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;

@Service
public class JwtService {
    @Value("${KEY}")
    private static String SECRECT_KEY ;
    public String getToken(User user) {
        return getToken(new HashMap<>(), user);
    }
    private String getToken(Map<String, Object> extraClaims, UserDetails user){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*24))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRECT_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
