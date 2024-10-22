package com.nhom2.businessRules.editInvoice;

public interface EditInvoiceOutputBoundary {
    public void exportResult(ResponseData responseData);
    public void exportError(ResponseError responseError);
    public void present(EditInvoiceOutputDTO outputDTO);
}
