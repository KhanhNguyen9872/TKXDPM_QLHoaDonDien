package com.nhom2.businessRules.deleteInvoice;

import com.nhom2.businessRules.*;

public class DeleteInvoiceUseCase implements DeleteInvoiceInputBoundary {
    private DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary;
    private DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary;

    public DeleteInvoiceUseCase(DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary, DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary) {
        this.deleteInvoiceOutputBoundary = deleteInvoiceOutputBoundary;
        this.deleteInvoiceDatabaseBoundary = deleteInvoiceDatabaseBoundary;
    }

    private boolean isExist(int maKH) {
        return this.deleteInvoiceDatabaseBoundary.isExist(maKH);
    }

    @Override
    public void execute(RequestData requestData) {
        ResponseData responseData = new ResponseData();
        ResponseError responseError = new ResponseError();

        if (!verify(requestData)) {
            responseError.setMsg("Dữ liệu không hợp lệ!");
            deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(requestData.getMaKH());

        if (!this.isExist(maKH)) {
            responseError.setMsg("Không tồn tại!");
            this.deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        this.deleteInvoiceDatabaseBoundary.deleteInvoice(maKH);

        responseData.setMsg("Đã xóa thành công!");
        this.deleteInvoiceOutputBoundary.exportResult(responseData);
    }

    private boolean verify(RequestData requestData) {
        try {
            int maKH = Integer.parseInt(requestData.getMaKH());
            
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

}
