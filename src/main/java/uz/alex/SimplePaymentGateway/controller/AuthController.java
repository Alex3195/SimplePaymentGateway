package uz.alex.SimplePaymentGateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.alex.SimplePaymentGateway.config.authentication.dto.req.SignInReqDto;
import uz.alex.SimplePaymentGateway.config.authentication.dto.res.AccessTokenResDto;
import uz.alex.SimplePaymentGateway.config.authentication.service.AuthenticationService;

@RestController
@RequestMapping("/api/v1/authentication")
public class AuthController {
    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public ResponseEntity<AccessTokenResDto> login(@RequestBody SignInReqDto req){
        String token = authenticationService.signIn(req);
        AccessTokenResDto authResponseDto = new AccessTokenResDto();
        authResponseDto.setAccessToken(token);
        return ResponseEntity.ok(authResponseDto);
    }
}
