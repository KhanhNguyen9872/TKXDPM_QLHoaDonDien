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

        if (!this.verify(editInvoiceInputDTO)) {
            responseError.setStatus("error");
            responseError.setMsg("Dữ liệu không hợp lệ!");
            editInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(editInvoiceInputDTO.getMaKH());
        if (!this.isExist(maKH)) {
            responseError.setStatus("error");
            responseError.setMsg("Mã KH không tồn tại!");
            editInvoiceOutputBoundary.exportError(responseError);
            return;
        }

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
        editInvoiceOutputBoundary.present(editInvoiceOutputDTO);
    }

    @Override
    public void executeFind(EditInvoiceInputDTO editInvoiceInputDTO) {
        EditInvoiceOutputDTO responseError = new EditInvoiceOutputDTO();

        if (!this.verifyFind(editInvoiceInputDTO)) {
            responseError.setStatus("error");
            responseError.setMsg("Dữ liệu không hợp lệ!");
            editInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(editInvoiceInputDTO.getMaKH());
        Boolean isE = this.isExist(maKH);
        if (isE == null) {
            responseError.setStatus("error");
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            editInvoiceOutputBoundary.exportError(responseError);
            return;
        } else if (!isE) {
            responseError.setStatus("error");
            responseError.setMsg("Không tồn tại! (KH: " + maKH + ")");
            editInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        Invoice invoice = editInvoiceDatabaseBoundary.getInvoice(maKH);

        EditInvoiceOutputDTO editInvoiceOutputDTO = new EditInvoiceOutputDTO();
        editInvoiceOutputDTO.setMaKH(String.valueOf(invoice.getMaKH()));
        editInvoiceOutputDTO.setTenKH(String.valueOf(invoice.getTenKH()));
        editInvoiceOutputDTO.setNgayHD(invoice.getNgayHD().toString());
        editInvoiceOutputDTO.setSoLuong(String.valueOf(invoice.getSoLuong()));
        editInvoiceOutputDTO.setDonGia(String.valueOf(invoice.getDonGia()));
        String quocTich = "", doiTuongKH = "";
        int dinhMuc = 0;
        if (invoice.getClass().equals(InvoiceVN.class)) {
            InvoiceVN invoiceVN = (InvoiceVN)invoice;
            doiTuongKH = invoiceVN.getDoiTuongKH();
            dinhMuc = invoiceVN.getDinhMuc();
        }
        if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
            InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
            quocTich = invoiceNuocNgoai.getQuocTich();
        }
        editInvoiceOutputDTO.setQuocTich(String.valueOf(quocTich));
        editInvoiceOutputDTO.setDoiTuongKH(String.valueOf(doiTuongKH));
        editInvoiceOutputDTO.setDinhMuc(String.valueOf(dinhMuc));

        editInvoiceOutputDTO.setStatus("success");
        editInvoiceOutputDTO.setMsg("Đã lấy thành công hóa đơn! (KH: " + maKH + ")");
        editInvoiceOutputBoundary.presentFind(editInvoiceOutputDTO);
    }

    private boolean verifyFind(EditInvoiceInputDTO editInvoiceInputDTO) {
        try {
            int maKH = Integer.parseInt(editInvoiceInputDTO.getMaKH());
            
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

    private boolean verify(EditInvoiceInputDTO requestData) {
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
            ex.printStackTrace();
            return false;
        }

        return true;
    }

    private Boolean isExist(int maKH) {
        return editInvoiceDatabaseBoundary.isExist(maKH);
    }
}
