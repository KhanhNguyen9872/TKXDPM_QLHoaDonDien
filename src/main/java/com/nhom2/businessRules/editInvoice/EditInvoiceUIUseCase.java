package com.nhom2.businessRules.editInvoice;

import com.nhom2.detail.editInvoice.EditInvoiceUIPresenter;

public class EditInvoiceUIUseCase implements EditInvoiceUIInputBoundary {
    private EditInvoiceUIPresenter editInvoiceUIPresenter;

    public EditInvoiceUIUseCase(EditInvoiceUIPresenter editInvoiceUIPresenter) {
        this.editInvoiceUIPresenter = editInvoiceUIPresenter;
    } 

    @Override
    public void execute(EditInvoiceUIInputDTO editInvoiceUIInputDTO) {
        String maKH = editInvoiceUIInputDTO.getMaKH();
        String tenKH = editInvoiceUIInputDTO.getTenKH();
        String ngayHD = editInvoiceUIInputDTO.getNgayHD();
        String soLuong = editInvoiceUIInputDTO.getSoLuong();
        String donGia = editInvoiceUIInputDTO.getDonGia();
        String quocTich = editInvoiceUIInputDTO.getQuocTich();
        String doiTuongKH = editInvoiceUIInputDTO.getDoiTuongKH();
        String dinhMuc = editInvoiceUIInputDTO.getDinhMuc();

        EditInvoiceUIOutputDTO editInvoiceUIOutputDTO = new EditInvoiceUIOutputDTO();
        editInvoiceUIOutputDTO.setMaKH(maKH);
        editInvoiceUIOutputDTO.setTenKH(tenKH);
        editInvoiceUIOutputDTO.setNgayHD(ngayHD);
        editInvoiceUIOutputDTO.setSoLuong(soLuong);
        editInvoiceUIOutputDTO.setDonGia(donGia);
        editInvoiceUIOutputDTO.setQuocTich(quocTich);
        editInvoiceUIOutputDTO.setDoiTuongKH(doiTuongKH);
        editInvoiceUIOutputDTO.setDinhMuc(dinhMuc);

        this.editInvoiceUIPresenter.present(editInvoiceUIOutputDTO);
    }
}
