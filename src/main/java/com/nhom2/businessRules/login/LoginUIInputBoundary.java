package com.nhom2.businessRules.login;

import com.nhom2.businessRules.forgot.ForgotUIInputBoundary;
import com.nhom2.businessRules.register.RegisterUIInputBoundary;

public interface LoginUIInputBoundary {
    public void execute(LoginUIInputDTO loginUIInputDTO);
    public void execute();

    public void setLoginInputBoundary(LoginInputBoundary loginInputBoundary);
    public void setRegisterUIInputBoundary(RegisterUIInputBoundary registerUIInputBoundary);
    public void setForgotUIInputBoundary(ForgotUIInputBoundary forgotUIInputBoundary);
}
