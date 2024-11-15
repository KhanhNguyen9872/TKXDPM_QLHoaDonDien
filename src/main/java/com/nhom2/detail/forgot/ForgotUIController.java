package com.nhom2.detail.forgot;

import com.nhom2.businessRules.forgot.ForgotUIInputBoundary;

public class ForgotUIController {
    private ForgotUIInputBoundary forgotUIInputBoundary;

    public ForgotUIController(ForgotUIInputBoundary forgotUIInputBoundary) {
        this.forgotUIInputBoundary = forgotUIInputBoundary;
    }

    public void execute() {
        this.forgotUIInputBoundary.execute();
    }
}
