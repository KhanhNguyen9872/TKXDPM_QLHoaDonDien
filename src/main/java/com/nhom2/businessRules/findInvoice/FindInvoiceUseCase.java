package com.nhom2.businessRules.findInvoice;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;
import com.nhom2.detail.observer.Publisher;

public class FindInvoiceUseCase extends Publisher implements FindInvoiceInputBoundary {
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

        if (!this.verify(findInvoiceInputDTO, responseError)) {
            findInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        List<Invoice> listInvoice = null;
        String typeFind = findInvoiceInputDTO.getFindType();
        String inputTimKiem = null;

        if (typeFind.equals("Mã KH")) {
            String maKH = findInvoiceInputDTO.getMaKH();
            listInvoice = findInvoiceDatabaseBoundary.findInvoiceMaKH(maKH);
            inputTimKiem = maKH;
        } else if (typeFind.equals("Tên KH")) {
            String tenKH = findInvoiceInputDTO.getTenKH();
            listInvoice = findInvoiceDatabaseBoundary.findInvoiceTenKH(tenKH);
            inputTimKiem = tenKH;
        } else if (typeFind.equals("Ngày HD")) {
            String ngayHD = findInvoiceInputDTO.getNgayHD();
            listInvoice = findInvoiceDatabaseBoundary.findInvoiceNgayHD(ngayHD);
            inputTimKiem = ngayHD;
        }
        
        if (listInvoice == null) {
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            this.findInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        if (listInvoice.size() == 0) {
            responseError.setMsg("Không có hóa đơn nào cho " + typeFind + " [" + inputTimKiem + "]!");
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

        notifySubscribers();
    }

    private boolean verify(FindInvoiceInputDTO findInvoiceInputDTO, FindInvoiceOutputDTO responseError) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String typeFind = findInvoiceInputDTO.getFindType();

        if (typeFind == null || typeFind.isEmpty()) {
            responseError.setMsg("typeFind,Chưa chọn loại tìm kiếm nào!");
            return false;
        }

        if (typeFind.equals("Mã KH")) {
            String maKHStr = findInvoiceInputDTO.getMaKH();
            if (maKHStr == null || maKHStr.isEmpty()) {
                responseError.setMsg("inputFind,Mã khách hàng không được để trống");
                return false;
            }
            
            try {
                int maKH = Integer.parseInt(maKHStr);
            } catch (Exception e) {
                responseError.setMsg("inputFind,Mã khách hàng phải là số");
                return false;
            }

        } else if (typeFind.equals("Tên KH")) {
            String tenKH = findInvoiceInputDTO.getTenKH();
            if (tenKH == null || tenKH.isEmpty()) {
                responseError.setMsg("inputFind,Tên khách hàng không được để trống");
                return false;
            }

        } else if (typeFind.equals("Ngày HD")) {
            String ngayHDStr = findInvoiceInputDTO.getNgayHD();
            Date ngayHD;
            if (ngayHDStr == null || ngayHDStr.isEmpty()) {
                responseError.setMsg("inputFind,Ngày HD không được để trống");
                return false;
            }

            try {
                ngayHD = formatter.parse(ngayHDStr);
            } catch (Exception e) {
                responseError.setMsg("inputFind,Định dạng ngày không hợp lệ");
                return false;
            }
        } else {
            responseError.setMsg("typeFind,Loại tìm kiếm không hợp lệ");
            return false;
        }
        
        return true;
    }
}
