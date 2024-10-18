package com.nhom2.detail.deleteInvoice;

import com.nhom2.businessRules.ResponseData;
import com.nhom2.businessRules.ResponseError;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.detail.observer.Publisher;

public class DeleteInvoicePresenter extends Publisher implements DeleteInvoiceOutputBoundary {
    private ModelView modelView;

    public DeleteInvoicePresenter(ModelView modelView) {
        this.modelView = modelView;
    }

    @Override
    public void exportError(ResponseError responseError) {
        this.modelView.setStatus("error");
        this.modelView.setMsg(responseError.getMsg());
        changeState();
    }

    @Override
    public void exportResult(ResponseData responseData) {
        this.modelView.setStatus("success");
        this.modelView.setMsg(responseData.getMsg());
        changeState();
    }

    private void changeState() {
        notifySubscribers();
    }
}
