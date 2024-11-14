package com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai;

import com.nhom2.detail.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUIPresenter;

public class AvgMoneyInvoiceNuocNgoaiUIUseCase implements AvgMoneyInvoiceNuocNgoaiUIInputBoundary {
    private AvgMoneyInvoiceNuocNgoaiUIPresenter avgMoneyInvoiceNuocNgoaiUIPresenter;

    public AvgMoneyInvoiceNuocNgoaiUIUseCase(AvgMoneyInvoiceNuocNgoaiUIPresenter avgMoneyInvoiceNuocNgoaiUIPresenter) {
        this.avgMoneyInvoiceNuocNgoaiUIPresenter = avgMoneyInvoiceNuocNgoaiUIPresenter;
    }

    @Override
    public void execute() {
        this.avgMoneyInvoiceNuocNgoaiUIPresenter.present();
    }
}
