package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceDatabaseBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputDTO;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceOutputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUseCase;
import com.nhom2.database.mysql.SumKHInvoiceDAOMySQL;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceController;
import com.nhom2.detail.sumKHInvoice.SumKHInvoicePresenter;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceViewModel;

public class SumKHInvoiceTest extends Nhom2Test {

    private SumKHInvoiceInputDTO getSumKHInvoiceInputDTO() {
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = new SumKHInvoiceInputDTO();
        return sumKHInvoiceInputDTO;
    }

    @Test
    public void getListInvoiceAll() throws Exception
    {
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(null, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("Tất cả");

        sumKHInvoiceController.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Tổng KH: 8 khách hàng");
    }

    @Test
    public void getListInvoiceNuocNgoai() throws Exception
    {
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(null, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("Nước ngoài");

        sumKHInvoiceController.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Tổng KH của (Nước ngoài): 3 khách hàng");
    }

    @Test
    public void getListInvoiceVN() throws Exception
    {
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(null, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("Việt Nam");

        sumKHInvoiceController.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Tổng KH của (Việt Nam): 5 khách hàng");
    }

    @Test
    public void getListInvoiceError() throws Exception
    {
        SumKHInvoiceViewModel sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(null, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
        SumKHInvoiceController sumKHInvoiceController = new SumKHInvoiceController(sumKHInvoiceInputBoundary);
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("");

        sumKHInvoiceController.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Dữ liệu không hợp lệ!");
    }
}
