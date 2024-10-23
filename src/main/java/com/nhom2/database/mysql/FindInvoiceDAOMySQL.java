package com.nhom2.database.mysql;

import com.nhom2.businessRules.findInvoice.FindInvoiceDatabaseBoundary;

public class FindInvoiceDAOMySQL extends DAOMySQL implements FindInvoiceDatabaseBoundary {
    public FindInvoiceDAOMySQL(String ipAddress, int port, String database, String username, String password) throws Exception {
        super(ipAddress, port, database, username, password);
    }

    
}
