package com.nhom2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.nhom2.businessRules.editInvoice.EditInvoiceDatabaseBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceOutputBoundary;
import com.nhom2.businessRules.editInvoice.EditInvoiceUseCase;
import com.nhom2.businessRules.editInvoice.EditInvoiceInputDTO;
import com.nhom2.database.mysql.EditInvoiceDAOMySQL;
import com.nhom2.detail.editInvoice.EditInvoicePresenter;
import com.nhom2.detail.editInvoice.EditInvoiceViewModel;

public class EditInvoiceTest extends Nhom2Test
{
    private EditInvoiceViewModel editInvoiceViewModel;
    private EditInvoiceInputBoundary editInvoiceInputBoundary;

    private void prepareUseCase() throws Exception {
        this.editInvoiceViewModel = new EditInvoiceViewModel();
        EditInvoiceOutputBoundary editInvoiceOutputBoundary = new EditInvoicePresenter(null, editInvoiceViewModel);
        EditInvoiceDatabaseBoundary editInvoiceDatabaseBoundary  = new EditInvoiceDAOMySQL(ipAddress, port, db, username, password);
        this.editInvoiceInputBoundary = new EditInvoiceUseCase(editInvoiceOutputBoundary, editInvoiceDatabaseBoundary);
    }

    private EditInvoiceInputDTO getEditInvoiceInputDTO() {
        EditInvoiceInputDTO editInvoiceInputDTO = new EditInvoiceInputDTO();
        editInvoiceInputDTO.setMaKH("1");
        editInvoiceInputDTO.setTenKH("Nguyễn Văn Sửa");
        editInvoiceInputDTO.setNgayHD("2023-12-05");
        editInvoiceInputDTO.setSoLuong("12");
        editInvoiceInputDTO.setDonGia("300");
        editInvoiceInputDTO.setLaNuocNgoai(false);
        editInvoiceInputDTO.setQuocTich("");
        editInvoiceInputDTO.setDoiTuongKH("Sinh hoạt");
        editInvoiceInputDTO.setDinhMuc("24");
        
        return editInvoiceInputDTO;
    }

    // SUCCESS
    @Test
    public void editInvoiceSuccess() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Đã sửa thành công (KH: " + requestData.getMaKH() + ")");
    }


    // ERROR
    @Test
    public void editInvoiceErrorTenKH() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setTenKH("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Tên không được để trống");

        requestData.setTenKH("asd");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Tên phải lớn hơn 5 kí tự");
    }

    @Test
    public void editInvoiceErrorNgayHD() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setNgayHD("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Ngày HD không được để trống");

        requestData.setNgayHD("20240101");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Định dạng ngày không hợp lệ");

        // requestData.setNgayHD("1999-01-01");
        // editInvoiceInputBoundary.execute(requestData);
        // assertEquals(editInvoiceViewModel.msg, "");

        requestData.setNgayHD("2099-01-01");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Ngày HD không được lớn hơn ngày hiện tại");
    }

    @Test
    public void editInvoiceErrorSoLuong() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setSoLuong("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Số lượng không được để trống");

        requestData.setSoLuong("abc");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Số lượng phải là số");

        requestData.setSoLuong("0");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Số lượng không được bé hơn 1");
    }

    @Test
    public void editInvoiceErrorDonGia() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setDonGia("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Đơn giá không được để trống");

        requestData.setDonGia("abc");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Đơn giá phải là số");

        requestData.setDonGia("0");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Đơn giá không được bé hơn 1");
    }

    @Test
    public void editInvoiceErrorQuocTich() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setLaNuocNgoai(true);

        requestData.setQuocTich("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Quốc tịch không được để trống");

        requestData.setQuocTich("VN");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Quốc tịch không được là Việt Nam");
    }

    @Test
    public void editInvoiceErrorDoiTuongKH() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setLaNuocNgoai(false);

        requestData.setDoiTuongKH("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Đối tượng khách hàng không được để trống");

        requestData.setDoiTuongKH("abc");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Đối tượng khách hàng VN phải là (Sinh hoạt | Kinh doanh | Sản xuất)");
    }

    @Test
    public void editInvoiceErrorDinhMuc() throws Exception
    {
        prepareUseCase();
        EditInvoiceInputDTO requestData = getEditInvoiceInputDTO();

        requestData.setLaNuocNgoai(false);

        requestData.setDinhMuc("");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Định mức không được để trống");

        requestData.setDinhMuc("abc");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Định mức phải là số");

        requestData.setDinhMuc("0");
        editInvoiceInputBoundary.execute(requestData);
        assertEquals(editInvoiceViewModel.msg, "Định mức không được bé hơn 1");
    }
}
