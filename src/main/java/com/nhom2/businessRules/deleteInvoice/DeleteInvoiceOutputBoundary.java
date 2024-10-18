package com.nhom2.businessRules.deleteInvoice;

import com.nhom2.businessRules.ResponseData;
import com.nhom2.businessRules.ResponseError;

public interface DeleteInvoiceOutputBoundary {
    public void exportResult(ResponseData responseData);
    public void exportError(ResponseError responseError);
}
