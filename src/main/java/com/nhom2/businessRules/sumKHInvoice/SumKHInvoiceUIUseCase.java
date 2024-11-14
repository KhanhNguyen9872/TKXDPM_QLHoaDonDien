package com.nhom2.businessRules.sumKHInvoice;

import com.nhom2.detail.sumKHInvoice.SumKHInvoiceUIPresenter;

public class SumKHInvoiceUIUseCase implements SumKHInvoiceUIInputBoundary {
    private SumKHInvoiceUIPresenter sumKHInvoiceUIPresenter;

    public SumKHInvoiceUIUseCase(SumKHInvoiceUIPresenter sumKHInvoiceUIPresenter) {
        this.sumKHInvoiceUIPresenter = sumKHInvoiceUIPresenter;   
    }

    @Override
    public void execute() {
        this.sumKHInvoiceUIPresenter.present();
    }


}
