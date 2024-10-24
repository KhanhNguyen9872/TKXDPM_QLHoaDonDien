package com.nhom2.businessRules.sumKHInvoice;

import java.util.List;

import com.nhom2.businessRules.entity.Invoice;

public interface SumKHInvoiceDatabaseBoundary {
    public List<Invoice> getAllInvoices();
}
