package com.nhom2.businessRules.quanLyHDTienDien;

import com.nhom2.businessRules.addInvoice.AddInvoiceUIInputBoundary;
import com.nhom2.businessRules.avgMoneyInvoiceNuocNgoai.AvgMoneyInvoiceNuocNgoaiUIInputBoundary;
import com.nhom2.businessRules.deleteInvoice.DeleteInvoiceUIInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUIInputBoundary;
import com.nhom2.businessRules.exportInvoiceByMonth.ExportInvoiceByMonthUIInputBoundary;
import com.nhom2.businessRules.findInvoice.FindInvoiceUIInputBoundary;
import com.nhom2.businessRules.login.LoginUIInputBoundary;
import com.nhom2.businessRules.sumKHInvoice.SumKHInvoiceUIInputBoundary;

public interface QuanLyHDTienDienInputBoundary {
    public void setAddInvoiceUIInputBoundary(AddInvoiceUIInputBoundary addInvoiceUIInputBoundary);
    public void setDeleteInvoiceUIInputBoundary(DeleteInvoiceUIInputBoundary deleteInvoiceUIInputBoundary);
    public void setEditInvoiceUIInputBoundary(EditInvoiceUIInputBoundary editInvoiceUIInputBoundary);
    public void setFindInvoiceUIInputBoundary(FindInvoiceUIInputBoundary findInvoiceUIInputBoundary);
    public void setExportInvoiceByMonthUIInputBoundary(ExportInvoiceByMonthUIInputBoundary exportInvoiceByMonthUIInputBoundary);
    public void setAvgMoneyInvoiceNuocNgoaiUIInputBoundary(AvgMoneyInvoiceNuocNgoaiUIInputBoundary avgMoneyInvoiceNuocNgoaiUIInputBoundary);
    public void setSumKHInvoiceUIInputBoundary(SumKHInvoiceUIInputBoundary sumKHInvoiceUIInputBoundary);
    public void setLoginUIInputBoundary(LoginUIInputBoundary loginUIInputBoundary);
    public void execute(QuanLyHDTienDienInputDTO quanLyHDTienDienInputDTO);
}
