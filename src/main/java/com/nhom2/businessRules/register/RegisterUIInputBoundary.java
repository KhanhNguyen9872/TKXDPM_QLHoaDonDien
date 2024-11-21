package com.nhom2.businessRules.register;

public interface RegisterUIInputBoundary {
    public void execute(RegisterUIInputDTO registerUIInputDTO);
    public void execute();

    public void setRegisterInputBoundary(RegisterInputBoundary registerInputBoundary);
}
