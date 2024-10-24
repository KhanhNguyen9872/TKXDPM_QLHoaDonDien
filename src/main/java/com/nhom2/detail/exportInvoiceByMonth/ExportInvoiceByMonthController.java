package com.nhom2.detail.exportInvoiceByMonth;

import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputDTO;

public class ExportInvoiceByMonthController {
    private ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary;

    public ExportInvoiceByMonthController(ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary) {
        this.exportInvoiceByMonthInputBoundary = exportInvoiceByMonthInputBoundary;
    }

    public void execute(ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO) {
        this.exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
    }
}
