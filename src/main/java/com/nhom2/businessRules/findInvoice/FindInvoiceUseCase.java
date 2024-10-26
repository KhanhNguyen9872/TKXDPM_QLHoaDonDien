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
        responseError.setStatus("error");

        if (!this.verify(findInvoiceInputDTO)) {
            responseError.setMsg("Dữ liệu không hợp lệ!");
            findInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        String maKH = findInvoiceInputDTO.getMaKH();
        String tenKH = findInvoiceInputDTO.getTenKH();
        String ngayHD = findInvoiceInputDTO.getNgayHD();

        List<Invoice> listInvoice = null;
        String loaiTimKiem = null;
        String inputTimKiem = "";

        if (maKH == null || maKH.isEmpty()) {
            
        } else {
            listInvoice = findInvoiceDatabaseBoundary.findInvoiceMaKH(maKH);
            loaiTimKiem = "Mã KH";
            inputTimKiem = maKH;
        }

        if (tenKH == null || tenKH.isEmpty()) {

        } else {
            listInvoice = findInvoiceDatabaseBoundary.findInvoiceTenKH(tenKH);
            loaiTimKiem = "Tên KH";
            inputTimKiem = tenKH;
        }

        if (ngayHD == null || ngayHD.isEmpty()) {

        } else {
            listInvoice = findInvoiceDatabaseBoundary.findInvoiceNgayHD(ngayHD);
            loaiTimKiem = "Ngày HD";
            inputTimKiem = ngayHD;
        }

        if (loaiTimKiem == null) {
            responseError.setMsg("Chưa chọn loại tìm kiếm nào!");
            findInvoiceOutputBoundary.exportError(responseError);
            return;
        }
        
        if (listInvoice == null) {
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            this.findInvoiceOutputBoundary.exportError(responseError);
        }

        if (listInvoice.size() == 0) {
            responseError.setMsg("Không có hóa đơn nào cho " + loaiTimKiem + " [" + inputTimKiem + "]!");
            findInvoiceOutputBoundary.exportError(responseError);
            return;
        }

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
            if (tenKH == null || tenKH.isEmpty()) {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
}
