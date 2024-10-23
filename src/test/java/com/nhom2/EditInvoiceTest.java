package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.detail.editInvoice.EditInvoiceController;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceViewModel;

public class EditInvoiceTest 
{
    private final String ipAddress = "127.0.0.1";
    private final int port = 3306;
    private final String db = "invoice";
    private final String username = "root";
    private final String password = "12345678";

    private EditInvoiceInputDTO getEditInvoiceInputDTO() {
        EditInvoiceInputDTO editInvoiceInputDTO = new EditInvoiceInputDTO();
        editInvoiceInputDTO.setMaKH("1");
        
        return editInvoiceInputDTO;
    }

    @Test
    public void editInvoiceSuccess() throws Exception
    {
        EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
        EditInvoiceController editInvoiceController = new EditInvoiceController(editInvoiceInputBoundary);

        // find id 1
        EditInvoiceInputDTO editInvoiceInputDTO = getEditInvoiceInputDTO();
        editInvoiceController.executeFind(editInvoiceInputDTO);
        
        assertEquals(editInvoiceViewModel.msg, "Đã lấy thành công hóa đơn! (KH: " + editInvoiceInputDTO.getMaKH() + ")");
        assertEquals(editInvoiceViewModel.maKH, editInvoiceInputDTO.getMaKH());

        // update name (+ "0") for id 1
        editInvoiceInputDTO.setTenKH(editInvoiceViewModel.tenKH + "0");
        editInvoiceInputDTO.setNgayHD(editInvoiceViewModel.ngayHD);
        editInvoiceInputDTO.setSoLuong(editInvoiceViewModel.soLuong);
        editInvoiceInputDTO.setDonGia(editInvoiceViewModel.donGia);
        editInvoiceInputDTO.setQuocTich(editInvoiceViewModel.quocTich);
        editInvoiceInputDTO.setDoiTuongKH(editInvoiceViewModel.doiTuongKH);
        editInvoiceInputDTO.setDinhMuc(editInvoiceViewModel.dinhMuc);

        editInvoiceController.execute(editInvoiceInputDTO);
        assertEquals(editInvoiceViewModel.msg, "Đã sửa thành công (KH: " + editInvoiceInputDTO.getMaKH() + ")");
    }

    @Test
    public void editInvoiceError() throws Exception
    {
        EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
        EditInvoiceController editInvoiceController = new EditInvoiceController(editInvoiceInputBoundary);

        // find id 1
        EditInvoiceInputDTO editInvoiceInputDTO = getEditInvoiceInputDTO();
        editInvoiceController.executeFind(editInvoiceInputDTO);
        
        assertEquals(editInvoiceViewModel.maKH, editInvoiceInputDTO.getMaKH());

        // update donGia (+ "a") for id 1
        editInvoiceInputDTO.setTenKH(editInvoiceViewModel.tenKH);
        editInvoiceInputDTO.setNgayHD(editInvoiceViewModel.ngayHD);
        editInvoiceInputDTO.setSoLuong(editInvoiceViewModel.soLuong);
        editInvoiceInputDTO.setDonGia(editInvoiceViewModel.donGia + "a");
        editInvoiceInputDTO.setQuocTich(editInvoiceViewModel.quocTich);
        editInvoiceInputDTO.setDoiTuongKH(editInvoiceViewModel.doiTuongKH);
        editInvoiceInputDTO.setDinhMuc(editInvoiceViewModel.dinhMuc);

        editInvoiceController.execute(editInvoiceInputDTO);
        assertEquals(editInvoiceViewModel.msg, "Dữ liệu không hợp lệ!");
    }
}
