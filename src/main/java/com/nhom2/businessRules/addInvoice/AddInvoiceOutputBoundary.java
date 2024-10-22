package com.nhom2.businessRules.addInvoice;

public interface AddInvoiceOutputBoundary {
    public void exportResult(ResponseData responseData);
    public void exportError(ResponseError responseError);
    public void present(AddInvoiceOutputDTO outputDTO);
}
