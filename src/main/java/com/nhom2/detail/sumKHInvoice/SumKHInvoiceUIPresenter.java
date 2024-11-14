package com.nhom2.detail.sumKHInvoice;

public class SumKHInvoiceUIPresenter {
    private SumKHInvoiceView sumKHInvoiceView;

    public SumKHInvoiceUIPresenter(SumKHInvoiceView sumKHInvoiceView) {
        this.sumKHInvoiceView = sumKHInvoiceView;
    }

    public void present() {
        this.sumKHInvoiceView.mainShow();
    }
}
