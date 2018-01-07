package com.thoughtworks.mstorderservice.service;


import com.thoughtworks.mstorderservice.configuration.security.JWTUser;
import com.thoughtworks.mstorderservice.configuration.security.LoginRequestUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface AuthService {
    void logout(HttpServletRequest authorization);

    JWTUser getAuthorizedJWTUser(HttpServletRequest request);

    boolean hasJWTToken(HttpServletRequest request);

    boolean isTokenInBlackList(HttpServletRequest request);

    JWTUser login(HttpServletResponse response, LoginRequestUser loginRequestUser);
}
