package com.nhom2.businessRules.getListInvoice;

import com.nhom2.detail.getListInvoice.GetListInvoiceView;

public class GetListInvoiceUIUseCase implements GetListInvoiceUIInputBoundary {
    private GetListInvoiceView getListInvoiceView;

    public GetListInvoiceUIUseCase(GetListInvoiceView getListInvoiceView) {
        this.getListInvoiceView = getListInvoiceView;
    } 

    @Override
    public void execute() {
        this.getListInvoiceView.mainShow();
    }
}
