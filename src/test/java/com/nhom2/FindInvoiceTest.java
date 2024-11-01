package com.nhom2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nhom2.businessRules.findInvoice.FindInvoiceDatabaseBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceInputDTO;
import com.nhom2.businessRules.findInvoice.FindInvoiceOutputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceUseCase;
import com.nhom2.database.mysql.FindInvoiceDAOMySQL;
import com.nhom2.detail.findInvoice.FindInvoicePresenter;
import com.nhom2.detail.findInvoice.FindInvoiceViewModel;

public class FindInvoiceTest extends Nhom2Test {
    private List<FindInvoiceViewModel> findInvoiceViewModels;
    private FindInvoiceInputBoundary findInvoiceInputBoundary;

    private void prepareUseCase() throws Exception {
        this.findInvoiceViewModels = new ArrayList<>();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary = new FindInvoicePresenter(null, findInvoiceViewModels);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        this.findInvoiceInputBoundary = new FindInvoiceUseCase(findInvoiceOutputBoundary, findInvoiceDatabaseBoundary);
    }

    private FindInvoiceInputDTO getFindInvoiceInputBoundary() {
        FindInvoiceInputDTO findInvoiceInputDTO = new FindInvoiceInputDTO();
        return findInvoiceInputDTO;
    }

    // SUCCESS
    @Test
    public void findInvoiceSuccessMaKH() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO requestData = getFindInvoiceInputBoundary();

        requestData.setFindType("Mã KH");
        requestData.setMaKH("1");

        findInvoiceInputBoundary.execute(requestData);
        assertEquals(findInvoiceViewModels.get(0).maKH, "1");
    }

    @Test
    public void findInvoiceSuccessTenKH() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO requestData = getFindInvoiceInputBoundary();

        requestData.setFindType("Tên KH");
        requestData.setTenKH("Văn");
        
        findInvoiceInputBoundary.execute(requestData);
        assertEquals(findInvoiceViewModels.size(), 4);
    }

    @Test
    public void findInvoiceSuccessNgayHD() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO requestData = getFindInvoiceInputBoundary();

        requestData.setFindType("Ngày HD");
        requestData.setNgayHD("2024-04-00");

        findInvoiceInputBoundary.execute(requestData);
        assertEquals(findInvoiceViewModels.size(), 3);
    }


    // ERROR
    @Test
    public void findInvoiceEmptyTypeFind() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO findInvoiceInputDTO = getFindInvoiceInputBoundary();
        findInvoiceInputDTO.setFindType("");

        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.get(0).msg, "Chưa chọn loại tìm kiếm nào!");
    }

    @Test
    public void findInvoiceErrorMaKH() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO findInvoiceInputDTO = getFindInvoiceInputBoundary();

        findInvoiceInputDTO.setFindType("Mã KH");
        findInvoiceInputDTO.setMaKH("");
        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.get(0).msg, "Mã khách hàng không được để trống");

        findInvoiceInputDTO.setMaKH("abc");
        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.get(0).msg, "Mã khách hàng phải là số");
    }

    @Test
    public void findInvoiceErrorTenKH() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO findInvoiceInputDTO = getFindInvoiceInputBoundary();

        findInvoiceInputDTO.setFindType("Tên KH");
        findInvoiceInputDTO.setTenKH("");
        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.get(0).msg, "Tên khách hàng không được để trống");
    }

    @Test
    public void findInvoiceErrorNgayHD() throws Exception
    {
        prepareUseCase();
        FindInvoiceInputDTO findInvoiceInputDTO = getFindInvoiceInputBoundary();

        findInvoiceInputDTO.setFindType("Ngày HD");
        findInvoiceInputDTO.setNgayHD("");
        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.get(0).msg, "Ngày HD không được để trống");

        findInvoiceInputDTO.setNgayHD("20240101");
        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.get(0).msg, "Định dạng ngày không hợp lệ");
    }
}
