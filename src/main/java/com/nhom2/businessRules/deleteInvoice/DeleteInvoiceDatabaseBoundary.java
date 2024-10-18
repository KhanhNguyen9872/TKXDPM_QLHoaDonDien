package com.nhom2.businessRules.deleteInvoice;

public interface DeleteInvoiceDatabaseBoundary {
    public void deleteInvoice(int maKH);
    public boolean isExist(int maKH);
}
