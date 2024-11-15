package com.nhom2.businessRules.forgot;

public class ForgotUIUseCase implements ForgotUIInputBoundary {
    private ForgotUIOutputBoundary forgotUIOutputBoundary;

    public ForgotUIUseCase(ForgotUIOutputBoundary forgotUIOutputBoundary) {
        this.forgotUIOutputBoundary = forgotUIOutputBoundary;
    }

    @Override
    public void execute() {
        this.forgotUIOutputBoundary.present();
    }

}
