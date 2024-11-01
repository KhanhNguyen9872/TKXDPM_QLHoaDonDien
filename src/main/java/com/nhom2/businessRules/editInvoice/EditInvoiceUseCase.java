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

        if (!this.verify(editInvoiceInputDTO, responseError)) {
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

    private boolean verify(EditInvoiceInputDTO requestData, EditInvoiceOutputDTO responseError) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String tenKH = requestData.getTenKH();
        try {
            if (tenKH == null || tenKH.isEmpty()) {
                throw new Exception("Tên không được để trống");
            }

            if (tenKH.length() < 5) {
                throw new Exception("Tên phải lớn hơn 5 kí tự");
            }
        } catch (Exception ex) {
            responseError.setMsg("tenKH," + ex.getMessage());
            return false;
        }

        try {
            String ngayHDStr = requestData.getNgayHD();
            Date ngayHD;

            if (ngayHDStr == null || ngayHDStr.isEmpty()) {
                throw new Exception("Ngày HD không được để trống");
            }

            try {
                ngayHD = formatter.parse(ngayHDStr);
            } catch (Exception e) {
                throw new Exception("Định dạng ngày không hợp lệ");
            }
            
            // Ngày hiện tại
            Date currentDate = new Date();

            if (ngayHD.after(currentDate)) {
                throw new Exception("Ngày HD không được lớn hơn ngày hiện tại");
            } else {

            }
            
        } catch (Exception e) {
            responseError.setMsg("ngayHD," + e.getMessage());
            return false;
        }
        
        try {
            String soLuongStr = requestData.getSoLuong();

            if (soLuongStr == null || soLuongStr.isEmpty()) {
                throw new Exception("Số lượng không được để trống");
            }

            int soLuong;
            try {
                soLuong = Integer.parseInt(soLuongStr);
            } catch (Exception e) {
                throw new Exception("Số lượng phải là số");
            }
            
            if (soLuong < 1) {
                throw new Exception("Số lượng không được bé hơn 1");
            }
        } catch (Exception e) {
            responseError.setMsg("soLuong," + e.getMessage());
            return false;
        }

        try {
            String donGiaStr = requestData.getDonGia();
            if (donGiaStr == null || donGiaStr.isEmpty()) {
                throw new Exception("Đơn giá không được để trống");
            }

            int donGia;
            try {
                donGia = Integer.parseInt(donGiaStr);
            } catch (Exception e) {
                throw new Exception("Đơn giá phải là số");
            }
            if (donGia < 1) {
                throw new Exception("Đơn giá không được bé hơn 1");
            }
        } catch (Exception e) {
            responseError.setMsg("donGia," + e.getMessage());
            return false;
        }

        try {
            boolean laNuocNgoai = requestData.isLaNuocNgoai();
            if (laNuocNgoai) {
                String quocTich = requestData.getQuocTich();
                if (quocTich == null || quocTich.isEmpty()) {
                    throw new Exception("quocTich,Quốc tịch không được để trống");
                }

                if (quocTich.toLowerCase().equals("vn") || quocTich.toLowerCase().equals("viet nam") || quocTich.toLowerCase().equals("vietnam") || quocTich.toLowerCase().equals("việt nam")) {
                    throw new Exception("quocTich,Quốc tịch không được là Việt Nam");
                }
            } else {
                String doiTuongKH = requestData.getDoiTuongKH();

                if (doiTuongKH == null || doiTuongKH.isEmpty()) {
                    throw new Exception("doiTuongKH,Đối tượng khách hàng không được để trống");
                }
                
                if (doiTuongKH.equals("Sinh hoạt") || doiTuongKH.equals("Kinh doanh") || doiTuongKH.equals("Sản xuất")) {

                } else {
                    throw new Exception("doiTuongKH,Đối tượng khách hàng VN phải là (Sinh hoạt | Kinh doanh | Sản xuất)");
                }

                String dinhMucStr = requestData.getDinhMuc();
                if (dinhMucStr == null || dinhMucStr.isEmpty()) {
                    throw new Exception("dinhMuc,Định mức không được để trống");
                }

                int dinhMuc;
                try {
                    dinhMuc = Integer.parseInt(dinhMucStr);
                } catch (Exception e) {
                    throw new Exception("dinhMuc,Định mức phải là số");
                }

                if (dinhMuc < 1) {
                    throw new Exception("dinhMuc,Định mức không được bé hơn 1");
                }
            }
        } catch (Exception e) {
            responseError.setMsg(e.getMessage());
            return false;
        }

        return true;
    }

    private Boolean isExist(int maKH) {
        return editInvoiceDatabaseBoundary.isExist(maKH);
    }
}
