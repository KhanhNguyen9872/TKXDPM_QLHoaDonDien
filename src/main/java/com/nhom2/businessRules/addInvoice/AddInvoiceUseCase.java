package com.nhom2.businessRules.addInvoice;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;
import com.nhom2.detail.observer.Publisher;

public class AddInvoiceUseCase extends Publisher implements AddInvoiceInputBoundary {
    private AddInvoiceOutputBoundary addInvoiceOutputBoundary;
    private AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary;

    public AddInvoiceUseCase(AddInvoiceOutputBoundary addInvoiceOutputBoundary, AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary) {
        this.addInvoiceOutputBoundary = addInvoiceOutputBoundary;
        this.addInvoiceDatabaseBoundary = addInvoiceDatabaseBoundary;
    }

    @Override
    public void execute(AddInvoiceInputDTO addInvoiceInputDTO) {
        AddInvoiceOutputDTO responseError = new AddInvoiceOutputDTO();
        responseError.setStatus("error");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Invoice invoice;

        if (!verify(addInvoiceInputDTO, responseError)) {
            this.addInvoiceOutputBoundary.exportError(responseError);
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

        notifySubscribers();
    }

    private boolean verify(AddInvoiceInputDTO requestData, AddInvoiceOutputDTO responseError) {
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

}
