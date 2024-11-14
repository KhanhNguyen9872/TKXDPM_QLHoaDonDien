package com.nhom2.businessRules.exportInvoiceByMonth;

import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthUIPresenter;

public class ExportInvoiceByMonthUIUseCase implements ExportInvoiceByMonthUIInputBoundary {
    private ExportInvoiceByMonthUIPresenter exportInvoiceByMonthUIPresenter;

    public ExportInvoiceByMonthUIUseCase(ExportInvoiceByMonthUIPresenter exportInvoiceByMonthUIPresenter) {
        this.exportInvoiceByMonthUIPresenter = exportInvoiceByMonthUIPresenter;
    }

    @Override
    public void execute() {
        this.exportInvoiceByMonthUIPresenter.present();
    }
}
