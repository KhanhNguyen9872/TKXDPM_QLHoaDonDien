package com.nhom2.detail.editInvoice;

import com.nhom2.businessRules.editInvoice.EditInvoiceUIOutputDTO;

public class EditInvoiceUIPresenter {
    private EditInvoiceView editInvoiceView;
    private EditInvoiceViewModel editInvoiceViewModel;

    public EditInvoiceUIPresenter(EditInvoiceView editInvoiceView, EditInvoiceViewModel editInvoiceViewModel) {
        this.editInvoiceView = editInvoiceView;
        this.editInvoiceViewModel = editInvoiceViewModel;
    }

    public void present(EditInvoiceUIOutputDTO editInvoiceUIOutputDTO) {
        String maKH = editInvoiceUIOutputDTO.getMaKH();
        String tenKH = editInvoiceUIOutputDTO.getTenKH();
        String ngayHD = editInvoiceUIOutputDTO.getNgayHD();
        String soLuong = editInvoiceUIOutputDTO.getSoLuong();
        String donGia = editInvoiceUIOutputDTO.getDonGia();
        String quocTich = editInvoiceUIOutputDTO.getQuocTich();
        String doiTuongKH = editInvoiceUIOutputDTO.getDoiTuongKH();
        String dinhMuc = editInvoiceUIOutputDTO.getDinhMuc();

        editInvoiceViewModel.maKH = maKH;
        editInvoiceViewModel.tenKH = tenKH;
        editInvoiceViewModel.ngayHD = ngayHD;
        editInvoiceViewModel.soLuong = soLuong;
        editInvoiceViewModel.donGia = donGia;
        editInvoiceViewModel.quocTich = quocTich;
        editInvoiceViewModel.doiTuongKH = doiTuongKH;
        editInvoiceViewModel.dinhMuc = dinhMuc;

        this.editInvoiceView.showInvoice(editInvoiceViewModel);
    }
}
