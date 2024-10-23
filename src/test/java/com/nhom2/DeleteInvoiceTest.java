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
    private DeleteInvoiceInputDTO getRequestData() {
        DeleteInvoiceInputDTO requestData = new DeleteInvoiceInputDTO();

        requestData.setMaKH("1");
        
        return requestData;
    }

    @Test
    public void deleteInvoiceSuccess() throws Exception
    {
        DeleteInvoiceViewModel deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(null, deleteInvoiceViewModel);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        DeleteInvoiceInputDTO requestData = getRequestData();
        deleteInvoiceInputBoundary.execute(requestData);
        
        assertEquals(deleteInvoiceViewModel.msg, "Đã xóa thành công! (KH: " + requestData.getMaKH() + ")");
    }

    @Test
    public void deleteInvoiceError() throws Exception
    {
        DeleteInvoiceViewModel deleteInvoiceViewModel = new DeleteInvoiceViewModel();
        DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary = new DeleteInvoicePresenter(null, deleteInvoiceViewModel);
        DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary = new DeleteInvoiceDAOMySQL(ipAddress, port, db, username, password);
        DeleteInvoiceInputBoundary deleteInvoiceInputBoundary = new DeleteInvoiceUseCase(deleteInvoiceOutputBoundary, deleteInvoiceDatabaseBoundary);

        DeleteInvoiceInputDTO requestData = getRequestData();

        requestData.setMaKH("ID01");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(deleteInvoiceViewModel.msg, "Dữ liệu không hợp lệ!");

        requestData.setMaKH("0");
        deleteInvoiceInputBoundary.execute(requestData);
        assertEquals(deleteInvoiceViewModel.msg, "Không tồn tại! (KH: " + requestData.getMaKH() + ")");
    }
}
