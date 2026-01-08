package com.example.security.controller;

import com.example.security.dto.ApiResponse;
import com.example.security.dto.request.LogInRequest;
import com.example.security.dto.request.UserRequest;
import com.example.security.dto.response.TokenResponse;
import com.example.security.dto.response.UserOutputV2;
import com.example.security.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Đăng ký tài khoản")
    @PostMapping("sign-up")
    public ApiResponse<TokenResponse> signUp(@RequestBody @Valid UserRequest signUpRequest){
        return ApiResponse.<TokenResponse>builder()
                .result(userService.signUp(signUpRequest))
                .code(200)
                .message("Đăng ký thành công")
                .build();
    }

    @PostMapping("log-in")
    public ApiResponse<TokenResponse> logIn(@RequestBody @Valid LogInRequest logInRequest) {
        return ApiResponse.<TokenResponse>builder()
                .result(userService.logIn(logInRequest))
                .code(200)
                .message("Đăng nhập thành công")
                .build();
    }

    @Operation(summary = "Lấy thông tin cá nhân")
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<UserOutputV2> getUserInformation(@RequestHeader("Authorization") String accessToken){
        return userService.getUserInformation(accessToken);
    }
}
