package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.addInvoice.*;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceViewModel;

public class AddInvoiceTest 
{
    private final String ipAddress = "127.0.0.1";
    private final int port = 3306;
    private final String db = "invoice";
    private final String username = "root";
    private final String password = "12345678";

    private AddInvoiceInputDTO getRequestData() {
        AddInvoiceInputDTO addInvoiceInputDTO = new AddInvoiceInputDTO();

        addInvoiceInputDTO.setTenKH("Khanh");
        addInvoiceInputDTO.setNgayHD("2023-12-31");
        addInvoiceInputDTO.setSoLuong("50");
        addInvoiceInputDTO.setDonGia("150");
        addInvoiceInputDTO.setDoiTuongKH("Sinh hoạt");
        addInvoiceInputDTO.setDinhMuc("55");
        
        return addInvoiceInputDTO;
    }

    @Test
    public void addInvoiceSuccess() throws Exception
    {
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(null);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        AddInvoiceInputDTO addInvoiceInputDTO = getRequestData();
        addInvoiceInputBoundary.execute(addInvoiceInputDTO);

        AddInvoiceViewModel addInvoiceViewModel = ((AddInvoicePresenter)addInvoiceOutputBoundary).getAddInvoiceViewModel();

        assertEquals(addInvoiceViewModel.msg, "Đã thêm thành công! (TenKH: " + addInvoiceInputDTO.getTenKH() + ")");
    }

    @Test
    public void addInvoiceError() throws Exception
    {
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(null);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setNgayHD("20240101");
        addInvoiceInputBoundary.execute(requestData);
        AddInvoiceViewModel addInvoiceViewModel = ((AddInvoicePresenter)addInvoiceOutputBoundary).getAddInvoiceViewModel();

        assertEquals(addInvoiceViewModel.msg, "Dữ liệu không hợp lệ!");
    }
}
