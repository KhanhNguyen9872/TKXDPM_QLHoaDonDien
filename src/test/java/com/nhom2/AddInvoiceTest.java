package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.addInvoice.*;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.detail.addInvoice.AddInvoiceController;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;

public class AddInvoiceTest 
{
    private final String ipAddress = "127.0.0.1";
    private final int port = 3306;
    private final String db = "invoice";
    private final String username = "root";
    private final String password = "12345678";

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
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(null);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();
        addInvoiceInputBoundary.execute(requestData);

        assertEquals(((AddInvoicePresenter)addInvoiceOutputBoundary).getAddInvoiceViewModel().msg, "Đã thêm thành công! (KH: " + requestData.getMaKH() + ")");
    }

    @Test
    public void addInvoiceError() throws Exception
    {
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(null);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        RequestData requestData = getRequestData();

        requestData.setMaKH("ID01");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(((AddInvoicePresenter)addInvoiceOutputBoundary).getAddInvoiceViewModel().msg, "Dữ liệu không hợp lệ!");

        requestData.setMaKH("1");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(((AddInvoicePresenter)addInvoiceOutputBoundary).getAddInvoiceViewModel().msg, "Đã tồn tại! (KH: " + requestData.getMaKH() + ")");
    }
}
