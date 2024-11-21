package com.nhom2.businessRules.deleteInvoice;

import com.nhom2.detail.observer.Publisher;

public class DeleteInvoiceUseCase extends Publisher implements DeleteInvoiceInputBoundary {
    private DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary;
    private DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary;

    public DeleteInvoiceUseCase(DeleteInvoiceOutputBoundary deleteInvoiceOutputBoundary, DeleteInvoiceDatabaseBoundary deleteInvoiceDatabaseBoundary) {
        this.deleteInvoiceOutputBoundary = deleteInvoiceOutputBoundary;
        this.deleteInvoiceDatabaseBoundary = deleteInvoiceDatabaseBoundary;
    }

    private Boolean isExist(int maKH) {
        return this.deleteInvoiceDatabaseBoundary.isExist(maKH);
    }

    @Override
    public void execute(DeleteInvoiceInputDTO deleteInvoiceInputDTO) {
        DeleteInvoiceOutputDTO responseError  = new DeleteInvoiceOutputDTO();
        responseError.setStatus("error");

        if (!verify(deleteInvoiceInputDTO, responseError)) {
            deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(deleteInvoiceInputDTO.getMaKH());

        Boolean isE = this.isExist(maKH);
        if (isE == null) {
            responseError.setMsg("Đã xảy ra lỗi tại Database!");
            deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        } else if (!isE) {
            responseError.setMsg("Không tồn tại! (KH: " + deleteInvoiceInputDTO.getMaKH() + ")");
            deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        deleteInvoiceDatabaseBoundary.deleteInvoice(maKH);

        DeleteInvoiceOutputDTO outputDTO = new DeleteInvoiceOutputDTO();
        outputDTO.setStatus("error");
        outputDTO.setMsg("Đã xóa thành công! (KH: " + deleteInvoiceInputDTO.getMaKH() + ")");
        deleteInvoiceOutputBoundary.present(outputDTO);

        notifySubscribers();
    }

    private boolean verify(DeleteInvoiceInputDTO deleteInvoiceInputDTO, DeleteInvoiceOutputDTO responseError) {
        try {
            String maKHStr = deleteInvoiceInputDTO.getMaKH();
            if (maKHStr == null || maKHStr.isEmpty()) {
                throw new Exception("Mã KH không được để trống");
            }
            
            int maKH;
            try {
                maKH = Integer.parseInt(maKHStr);
            } catch (Exception e) {
                throw new Exception("Mã KH phải là số");
            }
            
        } catch (Exception ex) {
            responseError.setMsg("maKH," + ex.getMessage());
            return false;
        }

        return true;
    }

}
