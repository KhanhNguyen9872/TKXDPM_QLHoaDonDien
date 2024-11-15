package com.nhom2.database.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nhom2.businessRules.register.RegisterDatabaseBoundary;

public class RegisterDAOMySQL extends DAOMySQL implements RegisterDatabaseBoundary {

    public RegisterDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    
    @Override
    public boolean register(String username, String email, String password) {
        boolean check = false;
        connect();

        String sql = "INSERT INTO account (username, email, password) VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, password);

            check = preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        close();

        return check;
    }

    @Override
    public boolean isExist(String username) {
        boolean check = false;
        connect();

        String sql = "SELECT username FROM account WHERE (username = ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    check = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        close();

        return check;
    }

}
