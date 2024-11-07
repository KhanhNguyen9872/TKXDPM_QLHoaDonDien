package com.nhom2.businessRules.sumKHInvoice;

import com.nhom2.detail.sumKHInvoice.SumKHInvoiceView;

public class SumKHInvoiceUIUseCase implements SumKHInvoiceUIInputBoundary {
    private SumKHInvoiceView sumKHInvoiceView;

    public SumKHInvoiceUIUseCase(SumKHInvoiceView sumKHInvoiceView) {
        this.sumKHInvoiceView = sumKHInvoiceView;   
    }

    @Override
    public void execute() {
        this.sumKHInvoiceView.mainShow();
    }


}
