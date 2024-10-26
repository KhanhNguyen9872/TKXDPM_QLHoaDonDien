package com.nhom2.businessRules.findInvoice;

import java.util.List;

import com.nhom2.businessRules.entity.Invoice;

public interface FindInvoiceDatabaseBoundary {
    public List<Invoice> findInvoiceMaKH(String maKH);
    public List<Invoice> findInvoiceTenKH(String tenKH);
    public List<Invoice> findInvoiceNgayHD(String ngayHD);
}
