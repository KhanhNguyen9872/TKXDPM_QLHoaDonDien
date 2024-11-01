package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputDTO;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceDatabaseBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceOutputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUseCase;
import com.nhom2.database.mysql.DeleteInvoiceDAOMySQL;
import com.nhom2.detail.deleteInvoice.DeleteInvoicePresenter;
import com.nhom2.detail.deleteInvoice.DeleteInvoiceViewModel;

public class DeleteInvoiceTest extends Nhom2Test 
{
    private DeleteInvoiceViewModel deleteInvoiceViewModel;
    private DeleteInvoiceInputBoundary deleteInvoiceInputBoundary;

    private void prepareUseCase() throws Exception {
        this.deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(null, deleteInvoiceViewModel);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        this.deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);
    }

    private DeleteInvoiceInputDTO getRequestData() {
        DeleteInvoiceInputDTO requestData = new DeleteInvoiceInputDTO();

        requestData.setMaKH("8");
        
        return requestData;
    }

    // SUCCESS
    @Test
    public void deleteInvoiceSuccess() throws Exception
    {
        prepareUseCase();
        DeleteInvoiceInputDTO requestData = getRequestData();

        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(deleteInvoiceViewModel.msg, "Đã xóa thành công! (KH: " + requestData.getMaKH() + ")");
    }


    // ERROR
    @Test
    public void deleteInvoiceErrorMaKH() throws Exception
    {
        prepareUseCase();
        DeleteInvoiceInputDTO requestData = getRequestData();

        requestData.setMaKH("");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(deleteInvoiceViewModel.msg, "Mã KH không được để trống");

        requestData.setMaKH("abc");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(deleteInvoiceViewModel.msg, "Mã KH phải là số");

        requestData.setMaKH("0");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(deleteInvoiceViewModel.msg, "Không tồn tại! (KH: " + requestData.getMaKH() + ")");
    }
}
