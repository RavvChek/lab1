package ru.ravvcheck.lab1.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ravvcheck.lab1.dto.JwtAuthResponse;
import ru.ravvcheck.lab1.dto.LoginRequest;
import ru.ravvcheck.lab1.dto.SignUpRequest;
import ru.ravvcheck.lab1.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public JwtAuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

    @PostMapping("/sign-up")
    public JwtAuthResponse signUp(@RequestBody SignUpRequest request) {
        return authService.signUp(request);
    }
}
