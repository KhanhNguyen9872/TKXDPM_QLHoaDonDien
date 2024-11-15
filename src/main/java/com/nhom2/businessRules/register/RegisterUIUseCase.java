package com.nhom2.businessRules.register;

public class RegisterUIUseCase implements RegisterUIInputBoundary {
    private RegisterUIOutputBoundary registerUIOutputBoundary;

    public RegisterUIUseCase(RegisterUIOutputBoundary registerUIOutputBoundary) {
        this.registerUIOutputBoundary = registerUIOutputBoundary;
    }

    @Override
    public void execute() {
        this.registerUIOutputBoundary.present();
    }

}
