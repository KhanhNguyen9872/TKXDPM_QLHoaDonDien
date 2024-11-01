package com.nhom2.detail.exportInvoiceByMonth;

import java.util.List;

import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthOutputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthOutputDTO;

public class ExportInvoiceByMonthPresenter implements ExportInvoiceByMonthOutputBoundary {
    private ExportInvoiceByMonthView exportInvoiceByMonthView;
    private List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModel;

    public ExportInvoiceByMonthPresenter(ExportInvoiceByMonthView exportInvoiceByMonthView, List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModel) {
        this.exportInvoiceByMonthView = exportInvoiceByMonthView;
        this.exportInvoiceByMonthViewModel = exportInvoiceByMonthViewModel;
    }

    @Override
    public void exportError(ExportInvoiceByMonthOutputDTO responseError) {
        this.exportInvoiceByMonthViewModel.clear();
        ExportInvoiceByMonthViewModel exportInvoiceByMonthViewModel = new ExportInvoiceByMonthViewModel();
        
        exportInvoiceByMonthViewModel.status = responseError.getStatus();
        String msg;
        String inputNameError;
        try {
            inputNameError = responseError.getMsg().split(",")[0];
            msg = responseError.getMsg().split(",")[1];

            if (inputNameError.equals("month")) {
                exportInvoiceByMonthViewModel.monthErr = true;
            } else {
                exportInvoiceByMonthViewModel.monthErr = false;
            }

        } catch (Exception e) {
            msg = responseError.getMsg();
        }
        
        exportInvoiceByMonthViewModel.msg = msg;

        this.exportInvoiceByMonthViewModel.add(exportInvoiceByMonthViewModel);

        if (this.exportInvoiceByMonthView != null) {
            this.exportInvoiceByMonthView.showMsgError(exportInvoiceByMonthViewModel);
        }
    }

    @Override
    public void present(List<ExportInvoiceByMonthOutputDTO> exportInvoiceByMonthOutputDTO) {
        this.exportInvoiceByMonthViewModel.clear();

        String maKH;
        String tenKH;
        String ngayHD;
        String soLuong;
        String donGia;
        String quocTich;
        String doiTuongKH;
        String dinhMuc;
        String thanhTien;

        for (ExportInvoiceByMonthOutputDTO outputDTO : exportInvoiceByMonthOutputDTO) {
            maKH = String.valueOf(outputDTO.getMaKH());
            tenKH = String.valueOf(outputDTO.getTenKH());
            ngayHD = String.valueOf(outputDTO.getNgayHD());
            soLuong = String.valueOf(outputDTO.getSoLuong());
            donGia = String.valueOf(outputDTO.getDonGia());
            quocTich = String.valueOf(outputDTO.getQuocTich());
            doiTuongKH = String.valueOf(outputDTO.getDoiTuongKH());
            dinhMuc = String.valueOf(outputDTO.getDinhMuc());
            thanhTien = String.valueOf(outputDTO.getThanhTien());

            this.exportInvoiceByMonthViewModel.add(new ExportInvoiceByMonthViewModel("success", "", maKH, tenKH, ngayHD, soLuong, donGia, quocTich, doiTuongKH, dinhMuc, thanhTien));
        }

        if (this.exportInvoiceByMonthView != null) {
            this.exportInvoiceByMonthView.showResult(this.exportInvoiceByMonthViewModel);
        }
    }

}
