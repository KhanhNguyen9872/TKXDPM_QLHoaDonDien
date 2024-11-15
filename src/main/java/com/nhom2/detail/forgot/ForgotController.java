package com.nhom2.detail.forgot;

import com.nhom2.businessRules.forgot.ForgotInputBoundary;
import com.nhom2.businessRules.forgot.ForgotInputDTO;

public class ForgotController {
    private ForgotInputBoundary forgotInputBoundary;

    public ForgotController(ForgotInputBoundary forgotInputBoundary) {
        this.forgotInputBoundary = forgotInputBoundary;
    }

    public void execute(ForgotInputDTO forgotInputDTO) {
        this.forgotInputBoundary.execute(forgotInputDTO);
    }

}
