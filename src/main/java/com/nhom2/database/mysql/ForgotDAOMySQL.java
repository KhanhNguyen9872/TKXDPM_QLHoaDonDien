package com.nhom2.database.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nhom2.businessRules.forgot.ForgotDatabaseBoundary;

public class ForgotDAOMySQL extends DAOMySQL implements ForgotDatabaseBoundary {
    public ForgotDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public boolean checkAccount(String username, String email) {
        boolean check = false;
        connect();

        String sql = "SELECT username FROM account WHERE (username = ?) AND (email = ?);";
        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, email);

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
    public void updatePassword(String username, String email, String password) {
        connect();

        String sql = "UPDATE account SET password = ? WHERE (username = ?) AND (email = ?);";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setString(1, password);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);

            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
            // TODO: handle exception
        }

        close();
    }
}
