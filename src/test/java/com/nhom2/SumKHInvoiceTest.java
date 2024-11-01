package com.nhom2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceDatabaseBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceInputDTO;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceOutputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUseCase;
import com.nhom2.database.mysql.SumKHInvoiceDAOMySQL;
import com.nhom2.detail.sumKHInvoice.SumKHInvoicePresenter;
import com.nhom2.detail.sumKHInvoice.SumKHInvoiceViewModel;

public class SumKHInvoiceTest extends Nhom2Test {
    private SumKHInvoiceViewModel sumKHInvoiceViewModel;
    private SumKHInvoiceInputBoundary sumKHInvoiceInputBoundary;

    private void prepareUseCase() throws Exception {
        this.sumKHInvoiceViewModel = new SumKHInvoiceViewModel();
        SumKHInvoiceOutputBoundary sumKHInvoiceOutputBoundary = new SumKHInvoicePresenter(null, sumKHInvoiceViewModel);
        SumKHInvoiceDatabaseBoundary sumKHInvoiceDatabaseBoundary = new SumKHInvoiceDAOMySQL(ipAddress, port, db, username, password);
        this.sumKHInvoiceInputBoundary = new SumKHInvoiceUseCase(sumKHInvoiceOutputBoundary, sumKHInvoiceDatabaseBoundary);
    }

    private SumKHInvoiceInputDTO getSumKHInvoiceInputDTO() {
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = new SumKHInvoiceInputDTO();
        return sumKHInvoiceInputDTO;
    }

    // SUCCESS
    @Test
    public void getListInvoiceAll() throws Exception
    {
        prepareUseCase();
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("Tất cả");

        sumKHInvoiceInputBoundary.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Tổng KH: 7 khách hàng");
    }

    @Test
    public void getListInvoiceNuocNgoai() throws Exception
    {
        prepareUseCase();
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("Nước ngoài");

        sumKHInvoiceInputBoundary.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Tổng KH của (Nước ngoài): 3 khách hàng");
    }

    @Test
    public void getListInvoiceVN() throws Exception
    {
        prepareUseCase();
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();
        sumKHInvoiceInputDTO.setLoaiKH("Việt Nam");

        sumKHInvoiceInputBoundary.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Tổng KH của (Việt Nam): 4 khách hàng");
    }


    // ERROR
    @Test
    public void getListInvoiceError() throws Exception
    {
        prepareUseCase();
        
        SumKHInvoiceInputDTO sumKHInvoiceInputDTO = getSumKHInvoiceInputDTO();

        sumKHInvoiceInputDTO.setLoaiKH("");
        sumKHInvoiceInputBoundary.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Loại khách hàng không được để trống");

        sumKHInvoiceInputDTO.setLoaiKH("loại A");
        sumKHInvoiceInputBoundary.execute(sumKHInvoiceInputDTO);
        assertEquals(sumKHInvoiceViewModel.msg, "Loại khách hàng không hợp lệ");
    }
}
