package com.nhom2.businessRules.sumKHInvoice;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;
import com.nhom2.businessRules.entity.TinhToanInvoice;
import com.nhom2.detail.observer.Publisher;

public class SumKHInvoiceUseCase extends Publisher implements SumKHInvoiceInputBoundary {
    private SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary;
    private SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary;

    public SumKHInvoiceUseCase(SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary, SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary) {
        this.sumKHInvoiceDatabaseBoundary = sumKHInvoiceDatabaseBoundary;
        this.sumKHInvoiceOutputBoundary = sumKHInvoiceOutputBoundary;
    }
    
    @Override
    public void execute(SumKHInvoiceInputDTO sumKHInvoiceInputDTO) {
        SumKHInvoiceOutputDTO responseError = new SumKHInvoiceOutputDTO();
        responseError.setStatus("error");

        if (!this.verify(sumKHInvoiceInputDTO, responseError)) {
            this.sumKHInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        String loaiKH = sumKHInvoiceInputDTO.getLoaiKH();

        List<Invoice> listInvoice = this.sumKHInvoiceDatabaseBoundary.getAllInvoices();
        
        if (listInvoice == null) {
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            this.sumKHInvoiceOutputBoundary.exportError(responseError);
        }

        List<Invoice> newListInvoice = filterLoaiKH(listInvoice, loaiKH);

        TinhToanInvoice tinhToanInvoice = new TinhToanInvoice();
        int total = tinhToanInvoice.tinhTongInvoice(newListInvoice);

        SumKHInvoiceOutputDTO sumKHInvoiceOutputDTO = new SumKHInvoiceOutputDTO();
        sumKHInvoiceOutputDTO.setLoaiKH(loaiKH);
        sumKHInvoiceOutputDTO.setTotal(String.valueOf(total));
        this.sumKHInvoiceOutputBoundary.present(sumKHInvoiceOutputDTO);

        notifySubscribers();
    }

    private List<Invoice> filterLoaiKH(List<Invoice> listInvoices, String loaiKH) {
        List<Invoice> newListInvoice = new ArrayList<>();

        for (Invoice invoice : listInvoices) {
            if (loaiKH.equals("Tất cả")) {

            } else if (loaiKH.equals("Nước ngoài")) {
                if (!invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                    continue;
                }
            } else if (loaiKH.equals("Việt Nam")) {
                if (!invoice.getClass().equals(InvoiceVN.class)) {
                    continue;
                }
            } else {
                continue;
            }

            newListInvoice.add(invoice);
        }

        return newListInvoice;
    }

    private boolean verify(SumKHInvoiceInputDTO sumKHInvoiceInputDTO, SumKHInvoiceOutputDTO responseError) {
        String loaiKH = sumKHInvoiceInputDTO.getLoaiKH();
        if (loaiKH == null || loaiKH.isEmpty()) {
            responseError.setMsg("loaiKH,Loại khách hàng không được để trống");
            return false;
        }

        if (loaiKH.equals("Tất cả") || loaiKH.equals("Việt Nam") || loaiKH.equals("Nước ngoài")) {

        } else {
            responseError.setMsg("loaiKH,Loại khách hàng không hợp lệ");
            return false;
        }
        
        return true;
    }

    
}
