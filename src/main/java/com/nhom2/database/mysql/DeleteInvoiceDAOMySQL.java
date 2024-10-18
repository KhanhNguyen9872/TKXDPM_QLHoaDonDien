package com.nhom2.database.mysql;

import java.sql.PreparedStatement;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;

public class DeleteInvoiceDAOMySQL extends DAOMySQL implements DeleteInvoiceDatabaseBoundary {
    public DeleteInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.ipAddress = ipAddress;
        this.port = port;
        this.database = database;
        this.username = username;
        this.password = password;
    }

    @Override
    public void deleteInvoice(int maKH) {
        connect();

        String sql = "DELETE FROM invoice WHERE (maKH = ?)";

        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
            preparedStatement.setInt(1, maKH);
            
            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
    }
}
