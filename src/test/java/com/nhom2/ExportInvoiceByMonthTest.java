package com.nhom2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthDatabaseBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthInputDTO;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthOutputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUseCase;
import com.nhom2.database.mysql.ExportInvoiceByMonthDAOMySQL;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthPresenter;
import com.nhom2.detail.exportInvoiceByMonth.ExportInvoiceByMonthViewModel;

public class ExportInvoiceByMonthTest extends Nhom2Test {
    private ExportInvoiceByMonthInputDTO getExportInvoiceByMonthInputDTO() {
        ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = new ExportInvoiceByMonthInputDTO();
        exportInvoiceByMonthInputDTO.setMonth("4");
        return exportInvoiceByMonthInputDTO;
    }

    @Test
    public void exportInvoiceByMonthSuccess() throws Exception
    {
        List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModels = new ArrayList<>();
        ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary = new ExportInvoiceByMonthPresenter(null, exportInvoiceByMonthViewModels);
        ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary = new ExportInvoiceByMonthDAOMySQL(ipAddress, port, db, username, password);
        ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary = new ExportInvoiceByMonthUseCase(exportInvoiceByMonthDatabaseBoundary, exportInvoiceByMonthOutputBoundary);

        ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = getExportInvoiceByMonthInputDTO();

        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.size(), 3);
    }

    @Test
    public void exportInvoiceByMonthEmpty() throws Exception
    {
        List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModels = new ArrayList<>();
        ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary = new ExportInvoiceByMonthPresenter(null, exportInvoiceByMonthViewModels);
        ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary = new ExportInvoiceByMonthDAOMySQL(ipAddress, port, db, username, password);
        ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary = new ExportInvoiceByMonthUseCase(exportInvoiceByMonthDatabaseBoundary, exportInvoiceByMonthOutputBoundary);

        ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = getExportInvoiceByMonthInputDTO();
        exportInvoiceByMonthInputDTO.setMonth("1");

        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.size(), 0);
    }
}
