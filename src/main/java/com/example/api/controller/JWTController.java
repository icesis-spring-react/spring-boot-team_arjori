package com.example.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwsHeader;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class JWTController {
    @Value("${algorithm}")
    private String algorithm;

    JwtEncoder encoder;

    @Autowired
    public JWTController(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    @PostMapping("/auth")
    public String token() {
        Instant now = Instant.now();
        long expiry = 300;

        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject("self")
                .build();

        JwsHeader jwsHeader = JwsHeader.with(() -> algorithm).build();
        return this.encoder.encode(JwtEncoderParameters.from(jwsHeader, claims)).getTokenValue();
    }
}
