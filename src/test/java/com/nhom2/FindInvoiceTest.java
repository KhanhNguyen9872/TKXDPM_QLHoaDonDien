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
    public FindInvoiceInputDTO getFindInvoiceInputBoundary() {
        FindInvoiceInputDTO findInvoiceInputDTO = new FindInvoiceInputDTO();
        findInvoiceInputDTO.setTenKH("Khanh");
        return findInvoiceInputDTO;
    }

    @Test
    public void findInvoiceSuccess() throws Exception
    {
        List<FindInvoiceViewModel> findInvoiceViewModels = new ArrayList<>();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary = new FindInvoicePresenter(null, findInvoiceViewModels);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        FindInvoiceInputBoundary findInvoiceInputBoundary = new FindInvoiceUseCase(findInvoiceOutputBoundary, findInvoiceDatabaseBoundary);
        
        findInvoiceInputBoundary.execute(getFindInvoiceInputBoundary());
        assertEquals(findInvoiceViewModels.size(), 2);
    }

    @Test
    public void findInvoiceEmpty() throws Exception
    {
        List<FindInvoiceViewModel> findInvoiceViewModels = new ArrayList<>();
        FindInvoiceOutputBoundary findInvoiceOutputBoundary = new FindInvoicePresenter(null, findInvoiceViewModels);
        FindInvoiceDatabaseBoundary findInvoiceDatabaseBoundary = new FindInvoiceDAOMySQL(ipAddress, port, db, username, password);
        FindInvoiceInputBoundary findInvoiceInputBoundary = new FindInvoiceUseCase(findInvoiceOutputBoundary, findInvoiceDatabaseBoundary);
        
        FindInvoiceInputDTO findInvoiceInputDTO = getFindInvoiceInputBoundary();
        findInvoiceInputDTO.setTenKH("Nhom2");

        findInvoiceInputBoundary.execute(findInvoiceInputDTO);
        assertEquals(findInvoiceViewModels.size(), 0);
    }
}
