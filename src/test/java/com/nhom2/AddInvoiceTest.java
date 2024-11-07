package com.nhom2;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.nhom2.businessRules.addInvoice.*;
import com.nhom2.database.mysql.AddInvoiceDAOMySQL;
import com.nhom2.detail.addInvoice.AddInvoicePresenter;
import com.nhom2.detail.addInvoice.AddInvoiceView;
import com.nhom2.detail.addInvoice.AddInvoiceViewModel;

public class AddInvoiceTest extends Nhom2Test
{
    private AddInvoiceInputBoundary addInvoiceInputBoundary;
    private AddInvoiceViewModel addInvoiceViewModel;

    private void prepareUseCase() throws Exception {
        this.addInvoiceViewModel = new AddInvoiceViewModel();
        AddInvoiceView addInvoiceView = new AddInvoiceView();
        AddInvoiceOutputBoundary addInvoiceOutputBoundary = new AddInvoicePresenter(addInvoiceView, addInvoiceViewModel);
        AddInvoiceDatabaseBoundary addInvoiceDatabaseBoundary = new AddInvoiceDAOMySQL(ipAddress, port, db, username, password);
        this.addInvoiceInputBoundary = new AddInvoiceUseCase(addInvoiceOutputBoundary, addInvoiceDatabaseBoundary);
    }

    private AddInvoiceInputDTO getRequestData() {
        AddInvoiceInputDTO addInvoiceInputDTO = new AddInvoiceInputDTO();

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);
        
        addInvoiceInputDTO.setTenKH("Khanh");
        addInvoiceInputDTO.setNgayHD(formattedDate);
        addInvoiceInputDTO.setSoLuong("50");
        addInvoiceInputDTO.setLaNuocNgoai(false);
        addInvoiceInputDTO.setDonGia("150");
        addInvoiceInputDTO.setDoiTuongKH("Sinh hoạt");
        addInvoiceInputDTO.setDinhMuc("55");
        
        return addInvoiceInputDTO;
    }

    // SUCCESS
    @Test
    public void addInvoiceSuccessVietNam() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO addInvoiceInputDTO = getRequestData();
        addInvoiceInputBoundary.execute(addInvoiceInputDTO);

        assertEquals(addInvoiceViewModel.msg, "Đã thêm thành công! (TenKH: " + addInvoiceInputDTO.getTenKH() + ")");
    }

    @Test
    public void addInvoiceSuccessNuocNgoai() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO addInvoiceInputDTO = getRequestData();
        addInvoiceInputDTO.setTenKH(addInvoiceInputDTO.getTenKH() + " NuocNgoai");
        addInvoiceInputDTO.setLaNuocNgoai(true);
        addInvoiceInputDTO.setQuocTich("USA");
        addInvoiceInputDTO.setDoiTuongKH("");
        addInvoiceInputDTO.setDinhMuc("");
        addInvoiceInputBoundary.execute(addInvoiceInputDTO);

        assertEquals(addInvoiceViewModel.msg, "Đã thêm thành công! (TenKH: " + addInvoiceInputDTO.getTenKH() + ")");
    }


    // ERROR
    @Test
    public void addInvoiceErrorTenKH() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setTenKH("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Tên không được để trống");

        requestData.setTenKH("asd");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Tên phải lớn hơn 5 kí tự");
    }

    @Test
    public void addInvoiceErrorNgayHD() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setNgayHD("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Ngày HD không được để trống");

        requestData.setNgayHD("20240101");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Định dạng ngày không hợp lệ");

        // requestData.setNgayHD("1999-01-01");
        // addInvoiceInputBoundary.execute(requestData);
        // assertEquals(addInvoiceViewModel.msg, "");

        requestData.setNgayHD("2099-01-01");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Ngày HD không được lớn hơn ngày hiện tại");
    }

    @Test
    public void addInvoiceErrorSoLuong() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setSoLuong("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Số lượng không được để trống");

        requestData.setSoLuong("abc");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Số lượng phải là số");

        requestData.setSoLuong("0");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Số lượng không được bé hơn 1");
    }

    @Test
    public void addInvoiceErrorDonGia() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setDonGia("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Đơn giá không được để trống");

        requestData.setDonGia("abc");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Đơn giá phải là số");

        requestData.setDonGia("0");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Đơn giá không được bé hơn 1");
    }

    @Test
    public void addInvoiceErrorQuocTich() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setLaNuocNgoai(true);

        requestData.setQuocTich("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Quốc tịch không được để trống");

        requestData.setQuocTich("VN");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Quốc tịch không được là Việt Nam");
    }

    @Test
    public void addInvoiceErrorDoiTuongKH() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setLaNuocNgoai(false);

        requestData.setDoiTuongKH("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Đối tượng khách hàng không được để trống");

        requestData.setDoiTuongKH("abc");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Đối tượng khách hàng VN phải là (Sinh hoạt | Kinh doanh | Sản xuất)");
    }

    @Test
    public void addInvoiceErrorDinhMuc() throws Exception
    {
        prepareUseCase();
        AddInvoiceInputDTO requestData = getRequestData();

        requestData.setLaNuocNgoai(false);

        requestData.setDinhMuc("");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Định mức không được để trống");

        requestData.setDinhMuc("abc");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Định mức phải là số");

        requestData.setDinhMuc("0");
        addInvoiceInputBoundary.execute(requestData);
        assertEquals(addInvoiceViewModel.msg, "Định mức không được bé hơn 1");
    }
}
