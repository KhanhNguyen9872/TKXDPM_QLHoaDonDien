package com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai;

public interface AvgMoneyInvoiceNuocNgoaiOutputBoundary {
    public void present(AvgMoneyInvoiceNuocNgoaiOutputDTO avgMoneyInvoiceNuocNgoaiOutputDTO);
    public void exportError(AvgMoneyInvoiceNuocNgoaiOutputDTO responseError);
}
