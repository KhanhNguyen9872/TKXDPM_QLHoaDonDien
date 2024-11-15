package com.nhom2.detail.register;

import com.nhom2.businessRules.register.RegisterUIInputBoundary;

public class RegisterUIController {
    private RegisterUIInputBoundary registerUIInputBoundary;

    public RegisterUIController(RegisterUIInputBoundary registerUIInputBoundary) {
        this.registerUIInputBoundary = registerUIInputBoundary;
    }

    public void execute() {
        this.registerUIInputBoundary.execute();
    }
}
