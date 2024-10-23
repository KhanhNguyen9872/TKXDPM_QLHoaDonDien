package com.nhom2.businessRules.getListInvoice;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class GetListInvoiceUseCase implements GetListInvoiceInputBoundary {
    private GetListInvoiceOutputBoundary getListInvoiceOutputBoundary;
    private GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary;

    public GetListInvoiceUseCase(GetListInvoiceOutputBoundary getListInvoiceOutputBoundary, GetListInvoiceDatabaseBoundary getListInvoiceDatabaseBoundary) {
        this.getListInvoiceOutputBoundary = getListInvoiceOutputBoundary;
        this.getListInvoiceDatabaseBoundary = getListInvoiceDatabaseBoundary;
    }

    @Override
    public void execute() {
        List<GetListInvoiceOutputDTO> listOutputDTO = new ArrayList<>();

        List<Invoice> listInvoice = this.getListInvoiceDatabaseBoundary.getAllInvoices();

        if (listInvoice == null) {
            GetListInvoiceOutputDTO responseError = new GetListInvoiceOutputDTO();
            responseError.setStatus("error");
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            this.getListInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        for (Invoice invoice : listInvoice) {
            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
                listOutputDTO.add(new GetListInvoiceOutputDTO(invoiceNuocNgoai.getMaKH(), invoiceNuocNgoai.getTenKH(), invoiceNuocNgoai.getNgayHD(), invoiceNuocNgoai.getSoLuong(), invoiceNuocNgoai.getDonGia(), invoiceNuocNgoai.getQuocTich(), "", 0, invoiceNuocNgoai.tinhThanhTien()));
            } else {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;
                listOutputDTO.add(new GetListInvoiceOutputDTO(invoiceVN.getMaKH(), invoiceVN.getTenKH(), invoiceVN.getNgayHD(), invoiceVN.getSoLuong(), invoiceVN.getDonGia(), "", invoiceVN.getDoiTuongKH(), invoiceVN.getDinhMuc(), invoiceVN.tinhThanhTien()));
            }
        }

        this.getListInvoiceOutputBoundary.present(listOutputDTO);
    }

}
