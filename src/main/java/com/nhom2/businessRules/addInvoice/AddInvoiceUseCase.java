package com.nhom2.businessRules.addInvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class AddInvoiceUseCase implements AddInvoiceInputBoundary {
    private AddInvoiceOutputBoundary addInvoiceOutputBoundary;
    private AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary;

    public AddInvoiceUseCase(AddInvoiceOutputBoundary addInvoiceOutputBoundary, AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary) {
        this.addInvoiceOutputBoundary = addInvoiceOutputBoundary;
        this.addInvoiceDatabaseBoundary = addInvoiceDatabaseBoundary;
    }

    private boolean isExist(int maKH) {
        return this.addInvoiceDatabaseBoundary.isExist(maKH);
    }

    @Override
    public void execute(RequestData requestData) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        // ResponseData responseData = new ResponseData();
        ResponseError responseError = new ResponseError();

        if (!verify(requestData)) {
            responseError.setMsg("Dữ liệu không hợp lệ!");
            addInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(requestData.getMaKH());

        if (this.isExist(maKH)) {
            responseError.setMsg("Đã tồn tại! (KH: " + requestData.getMaKH() + ")");
            this.addInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        String tenKH = requestData.getTenKH();
        Date ngayHD = null;

        try {
            ngayHD = formatter.parse(requestData.getNgayHD());
        } catch (Exception e) {
            
        }
        
        int soLuong = Integer.parseInt(requestData.getSoLuong());
        int donGia = Integer.parseInt(requestData.getDonGia());

        String quocTich = requestData.getQuocTich();

        if (quocTich == null || quocTich.isEmpty()) {
            String doiTuongKH = requestData.getDoiTuongKH();
            int dinhMuc = Integer.parseInt(requestData.getDinhMuc());
            
            InvoiceVN invoiceVN = new InvoiceVN();
            invoiceVN.setMaKH(maKH);
            invoiceVN.setTenKH(tenKH);
            invoiceVN.setNgayHD(ngayHD);
            invoiceVN.setDoiTuongKH(doiTuongKH);
            invoiceVN.setSoLuong(soLuong);
            invoiceVN.setDonGia(donGia);
            invoiceVN.setDinhMuc(dinhMuc);
            
            this.addInvoiceDatabaseBoundary.addInvoice(invoiceVN);
        } else {
            InvoiceNuocNgoai invoiceNuocNgoai = new InvoiceNuocNgoai();
            invoiceNuocNgoai.setMaKH(maKH);
            invoiceNuocNgoai.setTenKH(tenKH);
            invoiceNuocNgoai.setNgayHD(ngayHD);
            invoiceNuocNgoai.setSoLuong(soLuong);
            invoiceNuocNgoai.setDonGia(donGia);
            invoiceNuocNgoai.setQuocTich(quocTich);

            this.addInvoiceDatabaseBoundary.addInvoice(invoiceNuocNgoai);
        }

        // responseData.setMsg("Đã thêm thành công!");
        // this.addInvoiceOutputBoundary.exportResult(responseData);

        AddInvoiceOutputDTO outputDTO = new AddInvoiceOutputDTO("Đã thêm thành công! (KH: " + maKH + ")");

        this.addInvoiceOutputBoundary.present(outputDTO);
    }

    private boolean verify(RequestData requestData) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            int maKH = Integer.parseInt(requestData.getMaKH());
            String tenKH = requestData.getTenKH();
            Date ngayHD = formatter.parse(requestData.getNgayHD());
            int soLuong = Integer.parseInt(requestData.getSoLuong());
            int donGia = Integer.parseInt(requestData.getDonGia());

            String quocTich = requestData.getQuocTich();
            
            if (quocTich == null || quocTich.isEmpty()) {
                String doiTuongKH = requestData.getDoiTuongKH();
                int dinhMuc = Integer.parseInt(requestData.getDinhMuc());
                
                if (doiTuongKH.equals("Sinh hoạt") || doiTuongKH.equals("Kinh doanh") || doiTuongKH.equals("Sản xuất")) {

                } else {
                    return false;
                }
            }
            
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

}
