package com.nhom2.database.mysql;

import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceDatabaseBoundary;

public class SumKHInvoiceDAOMySQL extends DAOMySQL implements SumKHInvoiceDatabaseBoundary {
    public SumKHInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }
}
