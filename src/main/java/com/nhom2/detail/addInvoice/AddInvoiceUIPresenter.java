package com.nhom2.detail.addInvoice;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputDTO;
import com.nhom2.businessRules.addInvoice.AddInvoiceUIOutputBoundary;

public class AddInvoiceUIPresenter implements AddInvoiceUIOutputBoundary {
    private AddInvoiceUIViewModel addInvoiceViewModel;
    private AddInvoiceView addInvoiceView;
    
    public AddInvoiceUIPresenter(AddInvoiceView addInvoiceView, AddInvoiceUIViewModel addInvoiceViewModel) {
        this.addInvoiceView = addInvoiceView;
        this.addInvoiceViewModel = addInvoiceViewModel;
        this.addInvoiceViewModel.list = new ArrayList<>();
    }

    public void present(List<String> list) {
        this.addInvoiceViewModel.list.clear();
        for (String string : list) {
            this.addInvoiceViewModel.list.add(string);
        }

        this.addInvoiceView.mainShow(this.addInvoiceViewModel);
    }
}
