package dev.robgleason.controller;


import dev.robgleason.dto.LoginDto;
import dev.robgleason.dto.RegisterDto;
import dev.robgleason.services.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("api/auth")
@AllArgsConstructor
public class AuthController {
    private AuthService authService;

    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        String response = authService.register(registerDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        String response = authService.login(loginDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}