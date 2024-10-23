package com.nhom2.database.mysql;

import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiDatabaseBoundary;

public class AvgMoneyInvoiceNuocNgoaiDAOMySQL extends DAOMySQL implements AvgMoneyInvoiceNuocNgoaiDatabaseBoundary {
    public AvgMoneyInvoiceNuocNgoaiDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }
}
