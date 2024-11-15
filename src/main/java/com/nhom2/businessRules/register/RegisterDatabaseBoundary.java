package com.nhom2.businessRules.register;

public interface RegisterDatabaseBoundary {
    public boolean register(String username, String email, String password);
    public boolean isExist(String username);
}
