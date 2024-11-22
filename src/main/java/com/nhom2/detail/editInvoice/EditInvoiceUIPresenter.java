package com.nhom2.detail.editInvoice;

import com.nhom2.businessRules.editInvoice.EditInvoiceUIOutputDTO;

public class EditInvoiceUIPresenter {
    private EditInvoiceView editInvoiceView;
    private EditInvoiceViewModel editInvoiceViewModel;
    private EditInvoiceUIViewModel editInvoiceUIViewModel;

    public EditInvoiceUIPresenter(EditInvoiceView editInvoiceView, EditInvoiceViewModel editInvoiceViewModel, EditInvoiceUIViewModel editInvoiceUIViewModel) {
        this.editInvoiceView = editInvoiceView;
        this.editInvoiceViewModel = editInvoiceViewModel;
        this.editInvoiceUIViewModel = editInvoiceUIViewModel;
    }

    public void present(EditInvoiceUIOutputDTO editInvoiceUIOutputDTO) {
        this.editInvoiceUIViewModel.list.clear();
        for (String string : editInvoiceUIOutputDTO.getList()) {
            this.editInvoiceUIViewModel.list.add(string);
        }

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

        this.editInvoiceView.showInvoice(editInvoiceViewModel, editInvoiceUIViewModel);
    }
}
