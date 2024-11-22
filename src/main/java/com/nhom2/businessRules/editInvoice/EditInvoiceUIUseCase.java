package com.nhom2.businessRules.editInvoice;

import java.util.List;

import com.nhom2.detail.editInvoice.EditInvoiceUIPresenter;

public class EditInvoiceUIUseCase implements EditInvoiceUIInputBoundary {
    private EditInvoiceUIPresenter editInvoiceUIPresenter;
    private EditInvoiceUIDatabaseBoundary editInvoiceUIDatabaseBoundary;

    public EditInvoiceUIUseCase(EditInvoiceUIPresenter editInvoiceUIPresenter, EditInvoiceUIDatabaseBoundary editInvoiceUIDatabaseBoundary) {
        this.editInvoiceUIPresenter = editInvoiceUIPresenter;
        this.editInvoiceUIDatabaseBoundary = editInvoiceUIDatabaseBoundary;
    } 

    @Override
    public void execute(EditInvoiceUIInputDTO editInvoiceUIInputDTO) {
        List<String> list = this.editInvoiceUIDatabaseBoundary.getAllTypes();

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
        editInvoiceUIOutputDTO.setList(list);

        this.editInvoiceUIPresenter.present(editInvoiceUIOutputDTO);
    }
}
