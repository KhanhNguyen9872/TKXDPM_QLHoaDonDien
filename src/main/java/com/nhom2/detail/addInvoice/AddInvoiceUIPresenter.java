package com.nhom2.detail.addInvoice;

import com.nhom2.businessRules.addInvoice.AddInvoiceUIOutputDTO;

public class AddInvoiceUIPresenter {
    private AddInvoiceView addInvoiceView;
    
    public AddInvoiceUIPresenter(AddInvoiceView addInvoiceView) {
        this.addInvoiceView = addInvoiceView;
    }

    public void present(AddInvoiceUIOutputDTO addInvoiceUIOutputDTO) {
        this.addInvoiceView.mainShow();
    }
}
