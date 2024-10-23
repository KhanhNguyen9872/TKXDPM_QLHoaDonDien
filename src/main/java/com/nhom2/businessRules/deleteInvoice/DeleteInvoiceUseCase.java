package com.nhom2.businessRules.deleteInvoice;

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
    public void execute(DeleteInvoiceInputDTO deleteInvoiceInputDTO) {
        DeleteInvoiceOutputDTO responseError;

        if (!verify(deleteInvoiceInputDTO)) {
            responseError = new DeleteInvoiceOutputDTO();
            responseError.setStatus("error");
            responseError.setMsg("Dữ liệu không hợp lệ!");
            deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        int maKH = Integer.parseInt(deleteInvoiceInputDTO.getMaKH());

        if (!this.isExist(maKH)) {
            responseError = new DeleteInvoiceOutputDTO();
            responseError.setStatus("error");
            responseError.setMsg("Không tồn tại! (KH: " + deleteInvoiceInputDTO.getMaKH() + ")");
            deleteInvoiceOutputBoundary.exportError(responseError);
            return;
        }

        deleteInvoiceDatabaseBoundary.deleteInvoice(maKH);

        DeleteInvoiceOutputDTO outputDTO = new DeleteInvoiceOutputDTO();
        outputDTO.setStatus("error");
        outputDTO.setMsg("Đã xóa thành công! (KH: " + deleteInvoiceInputDTO.getMaKH() + ")");
        deleteInvoiceOutputBoundary.present(outputDTO);
    }

    private boolean verify(DeleteInvoiceInputDTO deleteInvoiceInputDTO) {
        try {
            int maKH = Integer.parseInt(deleteInvoiceInputDTO.getMaKH());
            
        } catch (Exception ex) {
            return false;
        }

        return true;
    }

}
