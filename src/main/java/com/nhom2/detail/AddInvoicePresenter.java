package com.nhom2.detail;

import com.nhom2.detail.observer.*;

import com.nhom2.businessRules.ResponseData;
import com.nhom2.businessRules.ResponseError;
import com.nhom2.businessRules.addInvoice.AddInvoiceOutputBoundary;

public class AddInvoicePresenter extends Publisher implements AddInvoiceOutputBoundary {
    private ModelView modelView;

    public AddInvoicePresenter(ModelView modelView) {
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
