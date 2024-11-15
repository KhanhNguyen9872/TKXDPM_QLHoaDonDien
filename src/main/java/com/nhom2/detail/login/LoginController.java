package com.nhom2.detail.login;

import com.nhom2.businessRules.login.LoginInputBoundary;
import com.nhom2.businessRules.login.LoginInputDTO;

public class LoginController {
    private LoginInputBoundary loginInputBoundary;

    public LoginController(LoginInputBoundary loginInputBoundary) {
        this.loginInputBoundary = loginInputBoundary;
    }

    public void execute(LoginInputDTO loginInputDTO) {
        this.loginInputBoundary.execute(loginInputDTO);
    }
}
