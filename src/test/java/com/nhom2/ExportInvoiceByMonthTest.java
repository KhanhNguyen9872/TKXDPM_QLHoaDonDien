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
    private List<ExportInvoiceByMonthViewModel> exportInvoiceByMonthViewModels;
    private ExportInvoiceByMonthInputBoundary exportInvoiceByMonthInputBoundary;

    private void prepareUseCase() throws Exception {
        this.exportInvoiceByMonthViewModels = new ArrayList<>();
        ExportInvoiceByMonthOutputBoundary exportInvoiceByMonthOutputBoundary = new ExportInvoiceByMonthPresenter(null, exportInvoiceByMonthViewModels);
        ExportInvoiceByMonthDatabaseBoundary exportInvoiceByMonthDatabaseBoundary = new ExportInvoiceByMonthDAOMySQL(ipAddress, port, db, username, password);
        this.exportInvoiceByMonthInputBoundary = new ExportInvoiceByMonthUseCase(exportInvoiceByMonthDatabaseBoundary, exportInvoiceByMonthOutputBoundary);
    }

    private ExportInvoiceByMonthInputDTO getExportInvoiceByMonthInputDTO() {
        ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = new ExportInvoiceByMonthInputDTO();
        return exportInvoiceByMonthInputDTO;
    }

    // SUCCESS
    @Test
    public void exportInvoiceByMonthSuccess() throws Exception
    {
        prepareUseCase();
        ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = getExportInvoiceByMonthInputDTO();

        exportInvoiceByMonthInputDTO.setMonth("4");
        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.size(), 3);
    }

    // ERROR
    @Test
    public void exportInvoiceByMonthError() throws Exception
    {
        prepareUseCase();
        ExportInvoiceByMonthInputDTO exportInvoiceByMonthInputDTO = getExportInvoiceByMonthInputDTO();

        exportInvoiceByMonthInputDTO.setMonth("");
        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.get(0).msg, "Tháng không được để trống");

        exportInvoiceByMonthInputDTO.setMonth("abc");
        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.get(0).msg, "Tháng phải là số");

        exportInvoiceByMonthInputDTO.setMonth("13");
        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.get(0).msg, "Tháng phải từ 1 đến 12");

        exportInvoiceByMonthInputDTO.setMonth("1");
        exportInvoiceByMonthInputBoundary.execute(exportInvoiceByMonthInputDTO);
        assertEquals(exportInvoiceByMonthViewModels.get(0).msg, "Không có hóa đơn nào cho tháng 1!");
    }
}
