package com.nhom2.detail.getListInvoice;

import java.util.List;
import java.util.ArrayList;

import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputDTO;

public class GetListInvoicePresenter implements GetListInvoiceOutputBoundary {
    private GetListInvoiceView getListInvoiceView;
    private List<GetListInvoiceViewModel> listViewModel;

    public GetListInvoicePresenter(GetListInvoiceView getListInvoiceView, List<GetListInvoiceViewModel> getListInvoiceViewModel) {
        this.getListInvoiceView = getListInvoiceView;
        this.listViewModel = getListInvoiceViewModel;
    }

    @Override
    public void exportError(GetListInvoiceOutputDTO responseData) {
        this.listViewModel.clear();
        GetListInvoiceViewModel getListInvoiceViewModel = new GetListInvoiceViewModel(responseData.getStatus(), responseData.getMsg());
        
        if (this.getListInvoiceView != null) {
            this.getListInvoiceView.showMsgError(getListInvoiceViewModel);
        }
    }

    @Override
    public void present(List<GetListInvoiceOutputDTO> listOutputDTO) {
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

        for (GetListInvoiceOutputDTO outputDTO : listOutputDTO) {
            maKH = String.valueOf(outputDTO.getMaKH());
            tenKH = String.valueOf(outputDTO.getTenKH());
            ngayHD = String.valueOf(outputDTO.getNgayHD());
            soLuong = String.valueOf(outputDTO.getSoLuong());
            donGia = String.valueOf(outputDTO.getDonGia());
            quocTich = String.valueOf(outputDTO.getQuocTich());
            doiTuongKH = String.valueOf(outputDTO.getDoiTuongKH());
            dinhMuc = String.valueOf(outputDTO.getDinhMuc());
            thanhTien = String.valueOf(outputDTO.getThanhTien());

            this.listViewModel.add(new GetListInvoiceViewModel("success", "", maKH, tenKH, ngayHD, soLuong, donGia, quocTich, doiTuongKH, dinhMuc, thanhTien));
        }

        if (this.getListInvoiceView != null) {
            this.getListInvoiceView.showResult(this.listViewModel);
        }
    }
}
