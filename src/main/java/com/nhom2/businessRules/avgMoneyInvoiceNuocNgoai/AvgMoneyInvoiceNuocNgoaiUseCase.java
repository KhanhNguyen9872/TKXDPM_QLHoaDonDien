package com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.TinhToanInvoice;

public class AvgMoneyInvoiceNuocNgoaiUseCase implements AvgMoneyInvoiceNuocNgoaiInputBoundary {
    private AvgMoneyInvoiceNuocNgoaiDatabaseBoundary avgMoneyInvoiceNuocNgoaiDatabaseBoundary;
    private AvgMoneyInvoiceNuocNgoaiOutputBoundary avgMoneyInvoiceNuocNgoaiOutputBoundary;

    public AvgMoneyInvoiceNuocNgoaiUseCase(AvgMoneyInvoiceNuocNgoaiDatabaseBoundary avgMoneyInvoiceNuocNgoaiDatabaseBoundary, AvgMoneyInvoiceNuocNgoaiOutputBoundary avgMoneyInvoiceNuocNgoaiOutputBoundary) {
        this.avgMoneyInvoiceNuocNgoaiDatabaseBoundary = avgMoneyInvoiceNuocNgoaiDatabaseBoundary;
        this.avgMoneyInvoiceNuocNgoaiOutputBoundary = avgMoneyInvoiceNuocNgoaiOutputBoundary;
    }

    @Override
    public void execute() {
        AvgMoneyInvoiceNuocNgoaiOutputDTO responseError = new AvgMoneyInvoiceNuocNgoaiOutputDTO();
        responseError.setStatus("error");

        List<InvoiceNuocNgoai> listInvoice = this.avgMoneyInvoiceNuocNgoaiDatabaseBoundary.getNuocNgoaiInvoices();
        List<Invoice> newListInvoice = new ArrayList<>();

        if (listInvoice == null) {
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            this.avgMoneyInvoiceNuocNgoaiOutputBoundary.exportError(responseError);
            return;
        }

        for (Invoice invoice: listInvoice) {
            if (!invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                continue;
            }
            
            newListInvoice.add(invoice);
        }

        TinhToanInvoice tinhToanInvoice = new TinhToanInvoice();
        double total = tinhToanInvoice.tinhTrungBinhThanhTien(newListInvoice);

        AvgMoneyInvoiceNuocNgoaiOutputDTO avgMoneyInvoiceNuocNgoaiOutputDTO = new AvgMoneyInvoiceNuocNgoaiOutputDTO();
        avgMoneyInvoiceNuocNgoaiOutputDTO.setStatus("success");
        avgMoneyInvoiceNuocNgoaiOutputDTO.setTotal(String.valueOf(total));
        this.avgMoneyInvoiceNuocNgoaiOutputBoundary.present(avgMoneyInvoiceNuocNgoaiOutputDTO);
    }

}
