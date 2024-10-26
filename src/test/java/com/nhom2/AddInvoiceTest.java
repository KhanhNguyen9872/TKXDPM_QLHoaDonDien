package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.addInvoice.*;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceViewModel;

public class AddInvoiceTest extends Nhom2Test
{
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
        AddInvoiceViewModel addInvoiceViewModel = new AddInvoiceViewModel();
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(null, addInvoiceViewModel);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        AddInvoiceInputDTO addInvoiceInputDTO = getRequestData();
        addInvoiceInputBoundary.execute(addInvoiceInputDTO);

        assertEquals(addInvoiceViewModel.msg, "Đã thêm thành công! (TenKH: " + addInvoiceInputDTO.getTenKH() + ")");
    }

    @Test
    public void addInvoiceError() throws Exception
    {
        AddInvoiceViewModel addInvoiceViewModel = new AddInvoiceViewModel();
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(null, addInvoiceViewModel);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        AddInvoiceInputBoundary addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);

        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setNgayHD("19990101");
        requestData.setDinhMuc("");
        requestData.setDoiTuongKH("");
        requestData.setDonGia("");
        addInvoiceInputBoundary.execute(requestData);

        assertEquals(addInvoiceViewModel.msg, "Dữ liệu không hợp lệ!");
    }
}
