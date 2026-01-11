package com.talhakoc.service.impl;

import com.talhakoc.dto.user.request.LoginRequestDto;
import com.talhakoc.dto.user.response.LoginResponseDto;
import com.talhakoc.security.CustomUserDetails;
import com.talhakoc.security.JwtService;
import com.talhakoc.service.IAuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;

    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        log.info("Login attempt for email: {}", loginRequestDto.getEmail());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequestDto.getEmail(),
                    loginRequestDto.getPassword()

                )
        );

        // şimdi burada yanlış şifre olursa veya yanlış kullanıcı adı olursa bie bir mesaj dönsün



        CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();

        String token = jwtService.generateToken(customUserDetails.getUsername());

        String role = customUserDetails.getAuthorities().stream()
                .findFirst()
                .map(GrantedAuthority::getAuthority)
                .map(auth -> auth.replace("ROLE_",""))
                .orElse("");

        log.info("Login successful for email {} with role {}", loginRequestDto.getEmail(), role);

        return LoginResponseDto.builder()
                .token(token)
                .email(customUserDetails.getUsername())
                .role(role)
                .expiresIn(jwtExpiration)
                .build();
    }
}
