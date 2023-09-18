package dev.robgleason.services;

import dev.robgleason.dto.LoginDto;
import dev.robgleason.dto.RegisterDto;

public interface AuthService {

    String register(RegisterDto registerDto);

    String login(LoginDto loginDto);
}
