package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceViewModel;

public class EditInvoiceTest extends Nhom2Test
{
    private EditInvoiceInputDTO getEditInvoiceInputDTO() {
        EditInvoiceInputDTO editInvoiceInputDTO = new EditInvoiceInputDTO();
        editInvoiceInputDTO.setMaKH("1");
        editInvoiceInputDTO.setTenKH("Nguyễn Văn Sửa");
        editInvoiceInputDTO.setNgayHD("2023-12-05");
        editInvoiceInputDTO.setSoLuong("12");
        editInvoiceInputDTO.setDonGia("300");
        // editInvoiceInputDTO.setQuocTich("");
        editInvoiceInputDTO.setDoiTuongKH("Sinh hoạt");
        editInvoiceInputDTO.setDinhMuc("24");
        
        return editInvoiceInputDTO;
    }

    @Test
    public void editInvoiceSuccess() throws Exception
    {
        EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);

        EditInvoiceInputDTO editInvoiceInputDTO = getEditInvoiceInputDTO();

        editInvoiceInputBoundary.execute(editInvoiceInputDTO);
        assertEquals(editInvoiceViewModel.msg, "Đã sửa thành công (KH: " + editInvoiceInputDTO.getMaKH() + ")");
    }

    @Test
    public void editInvoiceError() throws Exception
    {
        // EditInvoiceViewModel editInvoiceViewModel = new EditInvoiceViewModel();
        // EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null, editInvoiceViewModel);
        // EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        // EditInvoiceInputBoundary editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);

        // // find id 1
        // EditInvoiceInputDTO editInvoiceInputDTO = getEditInvoiceInputDTO();
        // // editInvoiceInputBoundary.executeFind(editInvoiceInputDTO);
        
        // assertEquals(editInvoiceViewModel.maKH, editInvoiceInputDTO.getMaKH());

        // // update donGia (+ "a") for id 1
        // editInvoiceInputDTO.setTenKH(editInvoiceViewModel.tenKH);
        // editInvoiceInputDTO.setNgayHD(editInvoiceViewModel.ngayHD);
        // editInvoiceInputDTO.setSoLuong(editInvoiceViewModel.soLuong);
        // editInvoiceInputDTO.setDonGia(editInvoiceViewModel.donGia + "a");
        // editInvoiceInputDTO.setQuocTich(editInvoiceViewModel.quocTich);
        // editInvoiceInputDTO.setDoiTuongKH(editInvoiceViewModel.doiTuongKH);
        // editInvoiceInputDTO.setDinhMuc(editInvoiceViewModel.dinhMuc);

        // editInvoiceInputBoundary.execute(editInvoiceInputDTO);
        // assertEquals(editInvoiceViewModel.msg, "Dữ liệu không hợp lệ!");
    }
}
