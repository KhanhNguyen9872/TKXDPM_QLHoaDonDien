package com.nhom2.businessRules.findInvoice;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class FindInvoiceUseCase implements FindInvoiceInputBoundary {
    private FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary;
    private FindInvoiceOutputBoundary findInvoiceOutputBoundary;

    public FindInvoiceUseCase(FindInvoiceOutputBoundary findInvoiceOutputBoundary, FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary) {
        this.findInvoiceDatabaseBoundary = findInvoiceDatabaseBoundary;
        this.findInvoiceOutputBoundary = findInvoiceOutputBoundary;
    }

    @Override
    public void execute(FindInvoiceInputDTO findInvoiceInputDTO) {
        List<FindInvoiceOutputDTO> listOutputDTO = new ArrayList<>();
        FindInvoiceOutputDTO responseError = new FindInvoiceOutputDTO();

        if (!this.verify(findInvoiceInputDTO)) {
            responseError.setStatus("error");
            responseError.setMsg("Dữ liệu không hợp lệ!");
            findInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        String tenKH = findInvoiceInputDTO.getTenKH();

        List<Invoice> listInvoice = findInvoiceDatabaseBoundary.findInvoice(tenKH);

        for (Invoice invoice : listInvoice) {
            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
                listOutputDTO.add(new FindInvoiceOutputDTO(invoiceNuocNgoai.getMaKH(), invoiceNuocNgoai.getTenKH(), invoiceNuocNgoai.getNgayHD(), invoiceNuocNgoai.getSoLuong(), invoiceNuocNgoai.getDonGia(), invoiceNuocNgoai.getQuocTich(), "", 0, invoiceNuocNgoai.tinhThanhTien()));
            } else {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;
                listOutputDTO.add(new FindInvoiceOutputDTO(invoiceVN.getMaKH(), invoiceVN.getTenKH(), invoiceVN.getNgayHD(), invoiceVN.getSoLuong(), invoiceVN.getDonGia(), "", invoiceVN.getDoiTuongKH(), invoiceVN.getDinhMuc(), invoiceVN.tinhThanhTien()));
            }
        }
        
        findInvoiceOutputBoundary.present(listOutputDTO);
    }

    private boolean verify(FindInvoiceInputDTO findInvoiceInputDTO) {
        try {
            String tenKH = String.valueOf(findInvoiceInputDTO.getTenKH());
            
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
