package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.RequestData;
import com.nhom2.businessRules.addInvoice.*;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.ModelView;

public class AddInvoiceTest 
{
    private RequestData getRequestData() {
        RequestData requestData = new RequestData();

        requestData.setMaKH("1");
        requestData.setTenKH("Khanh");
        requestData.setNgayHD("2023-12-31");
        requestData.setSoLuong("50");
        requestData.setDonGia("150");
        requestData.setDoiTuongKH("Sinh hoạt");
        requestData.setDinhMuc("55");
        
        return requestData;
    }

    @Test
    public void addInvoiceSuccess() throws Exception
    {
        ModelView modelView = new ModelView();
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(modelView);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        addInvoiceInputBoundary.execute(getRequestData());
        
        assertEquals(modelView.getMsg(), "Đã thêm thành công!");
    }

    @Test
    public void addInvoiceError() throws Exception
    {
        ModelView modelView = new ModelView();
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(modelView);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();

        requestData.setMaKH("ID01");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(modelView.getMsg(), "Dữ liệu không hợp lệ!");

        requestData.setMaKH("1");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(modelView.getMsg(), "Đã tồn tại!");
    }
}