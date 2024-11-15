package com.nhom2.detail.register;

import com.nhom2.businessRules.register.RegisterInputBoundary;
import com.nhom2.businessRules.register.RegisterInputDTO;

public class RegisterController {
    private RegisterInputBoundary registerInputBoundary;

    public RegisterController(RegisterInputBoundary registerInputBoundary) {
        this.registerInputBoundary = registerInputBoundary;
    }

    public void execute(RegisterInputDTO registerInputDTO) {
        this.registerInputBoundary.execute(registerInputDTO);
    }

}
