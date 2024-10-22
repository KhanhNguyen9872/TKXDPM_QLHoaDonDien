package com.nhom2.detail.editInvoice;

import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputDTO;
import com.nhom2.businessRules.editInvoice.ResponseData;
import com.nhom2.businessRules.editInvoice.ResponseError;

public class EditInvoicePresenter implements EditInvoiceOutputBoundary {
    private EditInvoiceView editInvoiceView;
    private EditInvoiceViewModel editInvoiceViewModel;

    public EditInvoicePresenter(EditInvoiceView editInvoiceView) {
        this.editInvoiceView = editInvoiceView;
    }

    public EditInvoiceViewModel getEditInvoiceViewModel() {
        return this.editInvoiceViewModel;
    }

    @Override
    public void exportError(ResponseError responseError) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void exportResult(ResponseData responseData) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void present(EditInvoiceOutputDTO outputDTO) {
        this.editInvoiceViewModel = new EditInvoiceViewModel();
        
        viewShow();
    }

    private void viewShow() {
        if (this.editInvoiceView != null) {
            this.editInvoiceView.showResult(this.editInvoiceViewModel);
        }
    }
    
}
