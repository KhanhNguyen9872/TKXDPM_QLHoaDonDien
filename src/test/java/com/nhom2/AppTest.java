package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.RequestData;
import com.nhom2.businessRules.addInvoice.*;
import com.nhom2.database.AddInvoiceDAOMySQL;
import com.nhom2.detail.AddInvoicePresenter;
import com.nhom2.detail.ModelView;

public class AppTest 
{
    @Test
    public void addInvoiceSuccess() throws Exception
    {
        ModelView modelView = new ModelView();
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(modelView);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        RequestData requestData = new RequestData();

        requestData.setMaKH("1");
        requestData.setTenKH("Khanh");
        requestData.setNgayHD("2023-12-31");
        requestData.setSoLuong("50");
        requestData.setDonGia("150");
        requestData.setDoiTuongKH("Sinh hoạt");
        requestData.setDinhMuc("55");

        addInvoiceInputBoundary.execute(requestData);
        
        assertEquals(modelView.getStatus(), "success");
        assertEquals(modelView.getMsg(), "Đã thêm thành công!");
    }

    @Test
    public void addInvoiceError() throws Exception
    {
        ModelView modelView = new ModelView();
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL("127.0.0.1", 3306, "invoice", "root", "12345678");
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(modelView);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        RequestData requestData = new RequestData();

        requestData.setMaKH("ID01");
        requestData.setTenKH("Khanh");
        requestData.setNgayHD("2023-12-31");
        requestData.setSoLuong("50");
        requestData.setDonGia("150");
        requestData.setDoiTuongKH("Sinh hoạt");
        requestData.setDinhMuc("55");

        addInvoiceInputBoundary.execute(requestData);
        
        assertEquals(modelView.getStatus(), "success");
        assertEquals(modelView.getMsg(), "Đã thêm thành công!");
    }
}
