package com.thoughtworks.mstorderservice.configuration.security;

import com.thoughtworks.mstorderservice.Repository.TokenAuthRepository;
import com.thoughtworks.mstorderservice.util.StringUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Map;

@Repository
public class JWTAuthRepositoryImpl implements TokenAuthRepository {

    @Value("${security.jwt.secret:_SEMS_JWT_SECRET_201801080808888}")
    private String jwtSecret;

    @Value("${security.jwt.expiration-in-seconds}")
    private long expirationInSeconds;

    @Override
    public String generateToken(Map<String, Object> payload) {
        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(new Date(System.currentTimeMillis() + expirationInSeconds * 1000))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    @Override
    public String extractAuthorizedPayload(String jwtToken) {
        return StringUtils.writeObjectAsJsonString(Jwts.parser().setSigningKey(jwtSecret)
                .parseClaimsJws(jwtToken)
                .getBody());
    }
}
