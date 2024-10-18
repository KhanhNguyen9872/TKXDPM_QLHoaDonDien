package com.nhom2.businessRules.addInvoice;

import java.util.List;

import com.nhom2.businessRules.model.*;

public interface AddInvoiceDatabaseBoundary {
    public void addInvoice(Invoice invoice);
    public List<Invoice> getAllInvoices();
    public boolean isExist(int maKH);
}
