package com.nhom2.businessRules.exportInvoiceByMonth;

import java.util.List;

import com.nhom2.businessRules.entity.Invoice;

public interface ExportInvoiceByMonthDatabaseBoundary {
    public List<Invoice> getInvoiceByMonth(int month);
}
