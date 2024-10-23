package com.nhom2.businessRules.addInvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class AddInvoiceUseCase implements AddInvoiceInputBoundary {
    private AddInvoiceOutputBoundary addInvoiceOutputBoundary;
    private AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary;

    public AddInvoiceUseCase(AddInvoiceOutputBoundary addInvoiceOutputBoundary, AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary) {
        this.addInvoiceOutputBoundary = addInvoiceOutputBoundary;
        this.addInvoiceDatabaseBoundary = addInvoiceDatabaseBoundary;
    }

    @Override
    public void execute(AddInvoiceInputDTO addInvoiceInputDTO) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        AddInvoiceOutputDTO responseError;
        Invoice invoice;

        if (!verify(addInvoiceInputDTO)) {
            responseError = new AddInvoiceOutputDTO();
            responseError.setStatus("error");
            responseError.setMsg("Dữ liệu không hợp lệ!");
            addInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        String tenKH = addInvoiceInputDTO.getTenKH();
        Date ngayHD = null;

        try {
            ngayHD = formatter.parse(addInvoiceInputDTO.getNgayHD());
        } catch (Exception e) {
            
        }
        
        int soLuong = Integer.parseInt(addInvoiceInputDTO.getSoLuong());
        int donGia = Integer.parseInt(addInvoiceInputDTO.getDonGia());

        String quocTich = addInvoiceInputDTO.getQuocTich();

        if (quocTich == null || quocTich.isEmpty()) {
            String doiTuongKH = addInvoiceInputDTO.getDoiTuongKH();
            int dinhMuc = Integer.parseInt(addInvoiceInputDTO.getDinhMuc());
            
            InvoiceVN invoiceVN = new InvoiceVN();
            invoiceVN.setTenKH(tenKH);
            invoiceVN.setNgayHD(ngayHD);
            invoiceVN.setDoiTuongKH(doiTuongKH);
            invoiceVN.setSoLuong(soLuong);
            invoiceVN.setDonGia(donGia);
            invoiceVN.setDinhMuc(dinhMuc);
            
            invoice = (Invoice)invoiceVN;
        } else {
            InvoiceNuocNgoai invoiceNuocNgoai = new InvoiceNuocNgoai();
            invoiceNuocNgoai.setTenKH(tenKH);
            invoiceNuocNgoai.setNgayHD(ngayHD);
            invoiceNuocNgoai.setSoLuong(soLuong);
            invoiceNuocNgoai.setDonGia(donGia);
            invoiceNuocNgoai.setQuocTich(quocTich);

            invoice = (Invoice)invoiceNuocNgoai;
        }

        this.addInvoiceDatabaseBoundary.addInvoice(invoice);

        AddInvoiceOutputDTO outputDTO = new AddInvoiceOutputDTO();
        outputDTO.setStatus("success");
        outputDTO.setMsg("Đã thêm thành công! (TenKH: " + tenKH + ")");

        this.addInvoiceOutputBoundary.present(outputDTO);
    }

    private boolean verify(AddInvoiceInputDTO requestData) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
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
            ex.printStackTrace();
            return false;
        }

        return true;
    }

}
