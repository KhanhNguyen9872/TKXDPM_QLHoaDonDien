package com.nhom2.businessRules.addInvoice;

import java.util.List;

import com.nhom2.businessRules.entity.*;

public interface AddInvoiceDatabaseBoundary {
    public void addInvoice(Invoice invoice);
    public boolean isExist(int maKH);
}
