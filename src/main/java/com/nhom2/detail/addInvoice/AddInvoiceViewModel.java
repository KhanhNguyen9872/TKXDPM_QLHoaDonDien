package com.nhom2.detail.addInvoice;

/*
 * ViewModel hoàn toàn là chuỗi (String, boolean) [boolean: đặt biến cờ]
 * View chỉ lấy dữ liệu và xuất lên màn hình [check theo biến cờ để xuất lên màn hình cho phù hợp]
 * Presenter xử lý [khởi tạo biến cờ vào ViewModel]
 * 
 */

public class AddInvoiceViewModel {
    public String status;
    public String msg;

    public AddInvoiceViewModel() {

    }
}
