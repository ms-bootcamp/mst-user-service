package com.thoughtworks.mstorderservice.api;

import com.thoughtworks.mstorderservice.configuration.security.JWTUser;
import com.thoughtworks.mstorderservice.configuration.security.LoginRequestUser;
import com.thoughtworks.mstorderservice.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/authentication")
public class AuthenticationController {

    @Autowired
    private AuthService authService;

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void logout(HttpServletRequest request) throws Exception {
        authService.logout(request);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public JWTUser login(@RequestBody LoginRequestUser loginRequestUser, HttpServletResponse response) throws Exception {
        return authService.login(response, loginRequestUser);
    }
}
