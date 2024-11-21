package com.nhom2.detail.register;

import com.nhom2.businessRules.register.RegisterUIInputBoundary;
import com.nhom2.businessRules.register.RegisterUIInputDTO;

public class RegisterUIController {
    private RegisterUIInputBoundary registerUIInputBoundary;

    public RegisterUIController(RegisterUIInputBoundary registerUIInputBoundary) {
        this.registerUIInputBoundary = registerUIInputBoundary;
    }

    public void execute(RegisterUIInputDTO registerUIInputDTO) {
        this.registerUIInputBoundary.execute(registerUIInputDTO);
    }
}
