package com.nhom2.businessRules.entity;

import java.util.List;

public class TinhToanInvoice {
    
    
    public TinhToanInvoice() {

    }

    public int tinhTongInvoice(List<Invoice> newListInvoice) {
        int total = 0;
        for (Invoice invoice : newListInvoice) {
            total += 1;
        }

        return total;
    }

    public double tinhTrungBinhThanhTien(List<Invoice> newListInvoice) {
        double thanhTien = 0;
        for (Invoice invoice : newListInvoice) {
            if (invoice.getClass().equals(InvoiceVN.class)) {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;
                thanhTien = thanhTien + invoiceVN.tinhThanhTien();
            }
            
            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
                thanhTien = thanhTien + invoiceNuocNgoai.tinhThanhTien();
            }
        }

        return thanhTien;
    }
}
