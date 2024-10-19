package com.nhom2.database.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOMySQL {
    protected Connection connection = null;
    protected String ipAddress;
    protected int port;
    protected String database;
    protected String username;
    protected String password;

    protected void connect() {
        if (this.connection == null) {
            try {
                this.connection = DriverManager.getConnection("jdbc:mysql://" + ipAddress + ":" + port + "/" + database + "?allowPublicKeyRetrieval=true&useSSL=false", username, password);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
    }
    
    protected void close() {
        if (this.connection != null) {
            try {
                this.connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            this.connection = null;
        }
    }

    public boolean isExist(int maKH) {
        boolean result = false;

        connect();

        String sql = "select maKH from invoice where (maKH = ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, maKH);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        close();

        return result;
    }
}
