package com.nhom2.businessRules.editInvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class EditInvoiceUseCase implements EditInvoiceInputBoundary {
    private EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary;
    private EditInvoiceOutputBoundary editInvoiceOutputBoundary;

    public EditInvoiceUseCase(EditInvoiceOutputBoundary editInvoiceOutputBoundary,
            EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary) {
        this.editInvoiceDatabaseBoundary = editInvoiceDatabaseBoundary;
        this.editInvoiceOutputBoundary = editInvoiceOutputBoundary;
    }

    @Override
    public void execute(EditInvoiceInputDTO editInvoiceInputDTO) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        EditInvoiceOutputDTO responseError = new EditInvoiceOutputDTO();
        responseError.setStatus("error");

        if (!this.verify(editInvoiceInputDTO)) {
            responseError.setMsg("Dữ liệu không hợp lệ!");
            editInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(editInvoiceInputDTO.getMaKH());

        Invoice invoice;
        String tenKH = editInvoiceInputDTO.getTenKH();
        Date ngayHD = null;
        try {
            ngayHD = formatter.parse(editInvoiceInputDTO.getNgayHD());
        } catch (Exception e) {

        }
        
        int soLuong = Integer.parseInt(editInvoiceInputDTO.getSoLuong());
        int donGia = Integer.parseInt(editInvoiceInputDTO.getDonGia());
        String doiTuongKH = editInvoiceInputDTO.getDoiTuongKH();
        int dinhMuc = Integer.parseInt(editInvoiceInputDTO.getDinhMuc());
        String quocTich = editInvoiceInputDTO.getQuocTich();

        if (quocTich == null || quocTich.isEmpty()) {
            invoice = new InvoiceVN(maKH, tenKH, ngayHD, soLuong, donGia, doiTuongKH, dinhMuc);
        } else {
            invoice = new InvoiceNuocNgoai(maKH, tenKH, ngayHD, soLuong, donGia, quocTich);
        }
        
        editInvoiceDatabaseBoundary.updateInvoice(invoice);

        EditInvoiceOutputDTO editInvoiceOutputDTO = new EditInvoiceOutputDTO();
        editInvoiceOutputDTO.setStatus("success");
        editInvoiceOutputDTO.setMsg("Đã sửa thành công (KH: " + maKH + ")");
        editInvoiceOutputBoundary.exportResult(editInvoiceOutputDTO);
    }

    private boolean verify(EditInvoiceInputDTO requestData) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        try {
            int maKH = Integer.parseInt(requestData.getMaKH());
            String tenKH = requestData.getTenKH();
            if (tenKH == null || tenKH.isEmpty()) {
                return false;
            }

            Date ngayHD = formatter.parse(requestData.getNgayHD());
            if (ngayHD == null) {
                return false;
            }

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

    private Boolean isExist(int maKH) {
        return editInvoiceDatabaseBoundary.isExist(maKH);
    }
}
