package com.nhom2.businessRules.login;

public interface LoginDatabaseBoundary {
    public boolean login(String username, String password);
    public boolean isAdmin(String username, String password);
}
