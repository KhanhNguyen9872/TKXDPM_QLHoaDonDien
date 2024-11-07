package com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai;

import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiView;

public class AvgMoneyInvoiceNuocNgoaiUIUseCase implements AvgMoneyInvoiceNuocNgoaiUIInputBoundary {
    private AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView;

    public AvgMoneyInvoiceNuocNgoaiUIUseCase(AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView) {
        this.avgMoneyInvoiceNuocNgoaiView = avgMoneyInvoiceNuocNgoaiView;
    }

    @Override
    public void execute() {
        this.avgMoneyInvoiceNuocNgoaiView.mainShow();
    }
}
