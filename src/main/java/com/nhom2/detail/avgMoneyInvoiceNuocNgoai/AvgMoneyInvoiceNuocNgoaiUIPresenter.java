package com.nhom2.detail.avgMoneyInvoiceNuocNgoai;

public class AvgMoneyInvoiceNuocNgoaiUIPresenter {
    private AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView;

    public AvgMoneyInvoiceNuocNgoaiUIPresenter(AvgMoneyInvoiceNuocNgoaiView avgMoneyInvoiceNuocNgoaiView) {
        this.avgMoneyInvoiceNuocNgoaiView = avgMoneyInvoiceNuocNgoaiView;
    }

    public void present() {
        this.avgMoneyInvoiceNuocNgoaiView.mainShow();
    }
}
