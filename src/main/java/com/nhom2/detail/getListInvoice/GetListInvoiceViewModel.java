package com.nhom2.detail.getListInvoice;

/*
 * ViewModel hoàn toàn là chuỗi (String, boolean) [boolean: đặt biến cờ]
 * View chỉ lấy dữ liệu và xuất lên màn hình [check theo biến cờ để xuất lên màn hình cho phù hợp]
 * Presenter xử lý [khởi tạo biến cờ vào ViewModel]
 * 
 */

public class GetListInvoiceViewModel {
    public String maKH;
    public String tenKH;
    public String ngayHD;
    public String soLuong;
    public String donGia;
    public String quocTich;
    public String doiTuongKH;
    public String dinhMuc;
    public String thanhTien;
    
    public GetListInvoiceViewModel(String maKH, String tenKH, String ngayHD, String soLuong, String donGia,
            String quocTich, String doiTuongKH, String dinhMuc, String thanhTien) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.ngayHD = ngayHD;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.quocTich = quocTich;
        this.doiTuongKH = doiTuongKH;
        this.dinhMuc = dinhMuc;
        this.thanhTien = thanhTien;
    }

    
}
