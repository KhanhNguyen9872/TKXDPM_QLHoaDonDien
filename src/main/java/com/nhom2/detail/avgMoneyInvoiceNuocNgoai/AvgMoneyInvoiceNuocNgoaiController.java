package com.nhom2.detail.avgMoneyInvoiceNuocNgoai;

import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiInputBoundary;

public class AvgMoneyInvoiceNuocNgoaiController {
    private AvgMoneyInvoiceNuocNgoaiInputBoundary avgMoneyInvoiceNuocNgoaiInputBoundary;

    public AvgMoneyInvoiceNuocNgoaiController(AvgMoneyInvoiceNuocNgoaiInputBoundary avgMoneyInvoiceNuocNgoaiInputBoundary) {
        this.avgMoneyInvoiceNuocNgoaiInputBoundary = avgMoneyInvoiceNuocNgoaiInputBoundary;
    }

    public void execute() {
        this.avgMoneyInvoiceNuocNgoaiInputBoundary.execute();
    }

}
