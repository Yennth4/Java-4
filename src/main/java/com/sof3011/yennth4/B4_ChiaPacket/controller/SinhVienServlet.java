package com.sof3011.yennth4.B4_ChiaPacket.controller;

import com.sof3011.yennth4.B4_ChiaPacket.entity.SinhVien;
import com.sof3011.yennth4.B4_ChiaPacket.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.math3.analysis.function.Sinh;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {
        "/sinh-vien/hien-thi", // GET
        "/sinh-vien/search",   // GET
        "/sinh-vien/remove",   // GET
        "/sinh-vien/detail",   // GET
        "/sinh-vien/view-update", // GET
        "/sinh-vien/update",   // POST : XU LY - J4 : CHI DUNG GET , POST
        "/sinh-vien/view-add", // GET
        "/sinh-vien/add"    // POST
        // link URL lay trong de bai , 1 URL la duy nhat
})
public class SinhVienServlet extends HttpServlet {

    private SinhVienService sinhVienService = new SinhVienService();
    private List<SinhVien> listSinhVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI(); // chi lay duoi URL phia tren thoi
        if (url.contains("hien-thi")) {
            // hien thi danh sach
            this.hienThi(request, response);
        } else if (url.contains("search")) {
            this.search(request, response);
        } else if (url.contains("remove")) {
            this.remove(request, response);
        } else if (url.contains("detail")) {
            this.detail(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.viewAdd(request, response);
        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Buoi4_TaiNguyen/add-sinh-vien.jsp")
                .forward(request , response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // forward nem ra ngoai le : di chuot qua forward nhan add
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien); // object
        request.getRequestDispatcher("/Buoi4_TaiNguyen/sinhviens.jsp")
                .forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        if (url.contains("update")) {
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        /*
//        C1: lam o muc co ban
        // B1: Lay du lieu tu jsp =. servlet
        String mssv = request.getParameter("mssv");
        String ten = request.getParameter("ten");
        int tuoi = Integer.valueOf(request.getParameter("tuoi"));
        String diaChi = request.getParameter("diaChi");
        Boolean gioiTinh = Boolean.valueOf(request.getParameter("gioiTinh"));

        // B2: Khoi tao doi tuong
//      C1: Khoi tao thuan
        SinhVien sv = new SinhVien(mssv,ten,tuoi,diaChi,gioiTinh);
//      C2: dung builder
        SinhVien sv1 = SinhVien.builder()
                // truyen tham so , thu tu lon xon van ok
                .diaChi(diaChi)
                .gioiTinh(Boolean.valueOf(gioiTinh))
                .mssv(mssv)
                .ten(ten)
                .tuoi(Integer.valueOf(tuoi))
                .build();
        // B3 : Goi service
        sinhVienService.addSinhVien(sv);

        // B4: Chuyen trang
        C1:
        listSinhVien = sinhVienService.getAll();
        request.setAttribute("listSV", listSinhVien); // object
        request.getRequestDispatcher("/Buoi4_TaiNguyen/sinhviens.jsp")
                .forward(request, response);
//         C2:
            response.sendRedirect("/sinh-vien/hien-thi");
 */

        // C2: Sử dụng Beanuntils
        SinhVien sv = new SinhVien();
        BeanUtils.populate(sv,request.getParameterMap());
        sinhVienService.addSinhVien(sv);
        response.sendRedirect("/sinh-vien/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {

    }
}
