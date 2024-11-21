package com.nhom2.businessRules.forgot;

public interface ForgotUIInputBoundary {
    public void execute(ForgotUIInputDTO forgotUIInputDTO);
    public void execute();

    public void setForgotInputBoundary(ForgotInputBoundary forgotInputBoundary);
}
