package com.nhom2.database.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nhom2.businessRules.login.LoginDatabaseBoundary;

public class LoginDAOMySQL extends DAOMySQL implements LoginDatabaseBoundary {
    public LoginDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public boolean login(String username, String password) {
        boolean check = false;
        connect();

        String sql = "SELECT username FROM account WHERE (username = ?) AND (password = ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

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

    @Override
    public boolean isAdmin(String username, String password) {
        boolean check = false;
        connect();

        String sql = "SELECT isAdmin FROM account WHERE (username = ?) AND (password = ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                if (rs.getBoolean("isAdmin")) {
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
