package com.nhom2.businessRules.forgot;

public interface ForgotOutputBoundary {
    public void exportError(ForgotOutputDTO forgotOutputDTO);
    public void exportResult(ForgotOutputDTO forgotOutputDTO);
}
