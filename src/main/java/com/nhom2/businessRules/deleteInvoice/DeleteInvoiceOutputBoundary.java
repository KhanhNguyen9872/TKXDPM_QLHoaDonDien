package com.nhom2.businessRules.deleteInvoice;

public interface DeleteInvoiceOutputBoundary {
    public void exportError(DeleteInvoiceOutputDTO responseError);
    public void present(DeleteInvoiceOutputDTO outputDTO);
}
