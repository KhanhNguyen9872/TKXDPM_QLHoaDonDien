package com.nhom2.detail.getListInvoice;

import java.util.List;
import java.util.ArrayList;

import com.nhom2.businessRules.ResponseData;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputBoundary;
import com.nhom2.businessRules.getListInvoice.GetListInvoiceOutputDTO;

public class GetListInvoicePresenter implements GetListInvoiceOutputBoundary {
    private GetListInvoiceView getListInvoiceView;
    private List<GetListInvoiceViewModel> listViewModel;

    public GetListInvoicePresenter(GetListInvoiceView getListInvoiceView) {
        this.getListInvoiceView = getListInvoiceView;
    }

    @Override
    public void exportResult(ResponseData responseData) {
        
    }

    @Override
    public void present(List<GetListInvoiceOutputDTO> listOutputDTO) {
        this.listViewModel = new ArrayList();

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

            this.listViewModel.add(new GetListInvoiceViewModel(maKH, tenKH, ngayHD, soLuong, donGia,quocTich, doiTuongKH, dinhMuc, thanhTien));
        }

        this.getListInvoiceView.showResult(this.listViewModel);;
    }

    public List<GetListInvoiceViewModel> getGetListInvoiceViewModel() {
        return this.listViewModel;
    }
}
