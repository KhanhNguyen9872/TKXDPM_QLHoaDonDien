package com.nhom2.businessRules.addInvoice;

import com.nhom2.businessRules.ResponseData;
import com.nhom2.businessRules.ResponseError;

public interface AddInvoiceOutputBoundary {
    public void exportResult(ResponseData responseData);
    public void exportError(ResponseError responseError);
    public void present(AddInvoiceOutputDTO outputDTO);
}
