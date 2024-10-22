package com.nhom2.businessRules.editInvoice;

import com.nhom2.businessRules.entity.Invoice;

public interface EditInvoiceDatabaseBoundary {
    public void updateInvoice(Invoice invoice);
    public Invoice getInvoice(int maKH);
    public boolean isExist(int maKH);
}
