package com.nhom2.businessRules.login;

public interface LoginOutputBoundary {
    public void exportError(LoginOutputDTO loginOutputDTO);
	public void exportResult(LoginOutputDTO loginOutputDTO);
}
