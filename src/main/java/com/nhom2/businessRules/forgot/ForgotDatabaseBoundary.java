package com.nhom2.businessRules.forgot;

public interface ForgotDatabaseBoundary {
    public boolean checkAccount(String username, String email);
    public void updatePassword(String username, String email, String password);
}
