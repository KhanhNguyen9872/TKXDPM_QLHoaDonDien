package com.nhom2.businessRules.exportInvoiceByMonth;

import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthView;

public class ExportInvoiceByMonthUIUseCase implements ExportInvoiceByMonthUIInputBoundary {
    private ExportInvoiceByMonthView exportInvoiceByMonthView;

    public ExportInvoiceByMonthUIUseCase(ExportInvoiceByMonthView exportInvoiceByMonthView) {
        this.exportInvoiceByMonthView = exportInvoiceByMonthView;
    }

    @Override
    public void execute() {
        this.exportInvoiceByMonthView.mainShow();
    }
}
