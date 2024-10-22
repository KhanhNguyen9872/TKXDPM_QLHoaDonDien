package com.nhom2.businessRules.getListInvoice;

import java.util.List;

public interface GetListInvoiceOutputBoundary {
    public void exportResult(ResponseData responseData);
    public void present(List<GetListInvoiceOutputDTO> outputDTO);
}
