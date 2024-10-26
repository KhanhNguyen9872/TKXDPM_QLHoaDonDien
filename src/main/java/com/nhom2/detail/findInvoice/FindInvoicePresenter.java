package com.nhom2.detail.findInvoice;

import java.util.List;

import com.nhom2.businessRules.findInvoice.FindInvoiceOutputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceOutputDTO;

public class FindInvoicePresenter implements FindInvoiceOutputBoundary {
    private FindInvoiceView findInvoiceView;
    private List<FindInvoiceViewModel> listViewModel;

    public FindInvoicePresenter(FindInvoiceView findInvoiceView, List<FindInvoiceViewModel> listViewModel) {
        this.findInvoiceView = findInvoiceView;
        this.listViewModel = listViewModel;
    }

    @Override
    public void exportError(FindInvoiceOutputDTO responseError) {
        this.listViewModel.clear();
        FindInvoiceViewModel findInvoiceViewModel = new FindInvoiceViewModel(responseError.getStatus(), responseError.getMsg());
        this.listViewModel.add(findInvoiceViewModel);
        
        if (this.findInvoiceView != null) {
            this.findInvoiceView.showMsgError(findInvoiceViewModel);
        }
    }

    @Override
    public void present(List<FindInvoiceOutputDTO> listInvoice) {
        this.listViewModel.clear();

        String maKH;
        String tenKH;
        String ngayHD;
        String soLuong;
        String donGia;
        String quocTich;
        String doiTuongKH;
        String dinhMuc;
        String thanhTien;

        for (FindInvoiceOutputDTO outputDTO : listInvoice) {
            maKH = String.valueOf(outputDTO.getMaKH());
            tenKH = String.valueOf(outputDTO.getTenKH());
            ngayHD = String.valueOf(outputDTO.getNgayHD());
            soLuong = String.valueOf(outputDTO.getSoLuong());
            donGia = String.valueOf(outputDTO.getDonGia());
            quocTich = String.valueOf(outputDTO.getQuocTich());
            doiTuongKH = String.valueOf(outputDTO.getDoiTuongKH());
            dinhMuc = String.valueOf(outputDTO.getDinhMuc());
            thanhTien = String.valueOf(outputDTO.getThanhTien());

            this.listViewModel.add(new FindInvoiceViewModel("success", "", maKH, tenKH, ngayHD, soLuong, donGia, quocTich, doiTuongKH, dinhMuc, thanhTien));
        }

        if (this.findInvoiceView != null) {
            this.findInvoiceView.showResult(this.listViewModel);
        }
    }
    
}
