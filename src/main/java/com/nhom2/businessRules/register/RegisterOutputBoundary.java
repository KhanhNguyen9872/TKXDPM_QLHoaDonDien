package com.nhom2.businessRules.register;

public interface RegisterOutputBoundary {

    public void exportResult(RegisterOutputDTO registerOutputDTO);
    public void exportError(RegisterOutputDTO registerOutputDTO);
}
