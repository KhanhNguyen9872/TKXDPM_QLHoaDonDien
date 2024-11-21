package com.nhom2.businessRules.addInvoice;

import java.util.List;

import com.nhom2.detail.addInvoice.AddInvoiceUIController;
import com.nhom2.detail.addInvoice.AddInvoiceUIPresenter;
import com.nhom2.detail.addInvoice.AddInvoiceView;

public class AddInvoiceUIUseCase implements AddInvoiceUIInputBoundary {
    private AddInvoiceUIPresenter addInvoiceUIPresenter;
    private AddInvoiceUIDatabaseBoundary addInvoiceUIDatabaseBoundary;

    public AddInvoiceUIUseCase(AddInvoiceUIPresenter addInvoiceUIPresenter, AddInvoiceUIDatabaseBoundary addInvoiceUIDatabaseBoundary) {
        this.addInvoiceUIPresenter = addInvoiceUIPresenter;
        this.addInvoiceUIDatabaseBoundary = addInvoiceUIDatabaseBoundary;
    } 

    @Override
    public void execute() {
        List<String> list = this.addInvoiceUIDatabaseBoundary.getAllTypes();
        this.addInvoiceUIPresenter.present(list);
    }

}
