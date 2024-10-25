package com.nhom2.businessRules.exportInvoiceByMonth;

import java.util.ArrayList;
import java.util.List;

import com.nhom2.businessRules.entity.Invoice;
import com.nhom2.businessRules.entity.InvoiceNuocNgoai;
import com.nhom2.businessRules.entity.InvoiceVN;

public class ExportInvoiceByMonthUseCase implements ExportInvoiceByMonthInputBoundary {
    private ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary;
    private ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary;

    public ExportInvoiceByMonthUseCase(ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary, ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary) {
        this.exportInvoiceByMonthDatabaseBoundary = exportInvoiceByMonthDatabaseBoundary;
        this.exportInvoiceByMonthOutputBoundary = exportInvoiceByMonthOutputBoundary;
    }

    @Override
    public void execute(ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO) {
        ExportInvoiceByMonthOutputDTO responseError = new ExportInvoiceByMonthOutputDTO();
        responseError.setStatus("error");

        if (!this.verify(exportInvoiceByMonthInputDTO)) {
            responseError.setMsg("Dữ liệu không hợp lệ!");
            this.exportInvoiceByMonthOutputBoundary.exportError(responseError);
            return;    
        }

        int month = Integer.parseInt(exportInvoiceByMonthInputDTO.getMonth());
        List<Invoice> listInvoices = this.exportInvoiceByMonthDatabaseBoundary.getInvoiceByMonth(month);

        List<ExportInvoiceByMonthOutputDTO> listOutputDTO = new ArrayList<>();
        ExportInvoiceByMonthOutputDTO outputDTO;

        if (listInvoices == null) {
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            this.exportInvoiceByMonthOutputBoundary.exportError(responseError);
            return;
        }

        if (listInvoices.size() == 0) {
            responseError.setMsg("Không có hóa đơn nào cho tháng " + month +"!");
            this.exportInvoiceByMonthOutputBoundary.exportError(responseError);
            return;
        }

        for (Invoice invoice : listInvoices) {
            if (invoice.getClass().equals(InvoiceNuocNgoai.class)) {
                InvoiceNuocNgoai invoiceNuocNgoai = (InvoiceNuocNgoai)invoice;
                listOutputDTO.add(new ExportInvoiceByMonthOutputDTO(invoiceNuocNgoai.getMaKH(), invoiceNuocNgoai.getTenKH(), invoiceNuocNgoai.getNgayHD(), invoiceNuocNgoai.getSoLuong(), invoiceNuocNgoai.getDonGia(), invoiceNuocNgoai.getQuocTich(), "", 0, invoiceNuocNgoai.tinhThanhTien()));
            } else {
                InvoiceVN invoiceVN = (InvoiceVN)invoice;
                listOutputDTO.add(new ExportInvoiceByMonthOutputDTO(invoiceVN.getMaKH(), invoiceVN.getTenKH(), invoiceVN.getNgayHD(), invoiceVN.getSoLuong(), invoiceVN.getDonGia(), "", invoiceVN.getDoiTuongKH(), invoiceVN.getDinhMuc(), invoiceVN.tinhThanhTien()));
            }
        }

        this.exportInvoiceByMonthOutputBoundary.present(listOutputDTO);
    }

    private boolean verify(ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO) {
        try {
            int month = Integer.parseInt(exportInvoiceByMonthInputDTO.getMonth());
            
            if (month < 1 || month > 12) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
