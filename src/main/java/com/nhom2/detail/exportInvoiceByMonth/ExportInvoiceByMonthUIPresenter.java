package com.nhom2.detail.exportInvoiceByMonth;

public class ExportInvoiceByMonthUIPresenter {
    private ExportInvoiceByMonthView exportInvoiceByMonthView;

    public ExportInvoiceByMonthUIPresenter(ExportInvoiceByMonthView exportInvoiceByMonthView) {
        this.exportInvoiceByMonthView = exportInvoiceByMonthView;    
    }

    public void present() {
        this.exportInvoiceByMonthView.mainShow();
    }
}
