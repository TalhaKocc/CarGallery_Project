package com.talhakoc.service;


import com.talhakoc.dto.user.request.LoginRequestDto;
import com.talhakoc.dto.user.response.LoginResponseDto;

public interface IAuthService {
    LoginResponseDto login(LoginRequestDto loginRequestDto);
}
