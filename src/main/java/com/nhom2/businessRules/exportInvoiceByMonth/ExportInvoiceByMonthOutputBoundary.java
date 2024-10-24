package com.nhom2.businessRules.exportInvoiceByMonth;

import java.util.List;

public interface ExportInvoiceByMonthOutputBoundary {
    public void exportError(ExportInvoiceByMonthOutputDTO exportInvoiceByMonthOutputDTO);
    public void present(List<ExportInvoiceByMonthOutputDTO> exportInvoiceByMonthOutputDTO);
}
