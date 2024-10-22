package com.nhom2.businessRules.deleteInvoice;

public interface DeleteInvoiceOutputBoundary {
    public void exportResult(ResponseData responseData);
    public void exportError(ResponseError responseError);
    public void present(DeleteInvoiceOutputDTO outputDTO);
}
