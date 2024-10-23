package com.nhom2.businessRules.findInvoice;

import java.util.List;

public interface FindInvoiceOutputBoundary {
    public void exportError(FindInvoiceOutputDTO responseError);
    public void present(List<FindInvoiceOutputDTO> listInvoice);
}
