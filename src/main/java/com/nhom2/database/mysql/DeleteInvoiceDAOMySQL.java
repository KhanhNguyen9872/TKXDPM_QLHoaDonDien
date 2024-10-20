package com.nhom2.database.mysql;

import java.sql.PreparedStatement;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;

public class DeleteInvoiceDAOMySQL extends DAOMySQL implements DeleteInvoiceDatabaseBoundary {
    
    public DeleteInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    @Override
    public void deleteInvoice(int maKH) {
        connect();

        String sql = "DELETE FROM invoice WHERE (maKH = ?)";

        try {
            PreparedStatement preparedStatement = getPrepareStatement(sql);
            preparedStatement.setInt(1, maKH);
            
            preparedStatement.execute();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        close();
    }
}
