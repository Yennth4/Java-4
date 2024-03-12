package com.sof3011.yennth4.B4_ChiaPacket.controller;

import com.sof3011.yennth4.B4_ChiaPacket.entity.SinhVien;
import com.sof3011.yennth4.B4_ChiaPacket.service.SinhVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {
        "/sinh-vien/hien-thi" , // GET
        "/sinh-vien/search" ,   // GET
        "/sinh-vien/remove" ,   // GET
        "/sinh-vien/detail" ,   // GET
        "/sinh-vien/view-update" , // GET
        "/sinh-vien/update" ,   // POST : XU LY - J4 : CHI DUNG GET , POST
        "/sinh-vien/view-add" , // GET
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

            this.hienThi(request , response);
        } else if (url.contains("search")) {
            this.search(request , response);

        } else if (url.contains("remove")) {
            this.remove(request , response);

        } else if (url.contains("detail")) {
            this.detail(request , response);

        } else if (url.contains("view-update")) {
            this.viewUpdate(request , response);

        } else {
            this.viewAdd(request , response);

        }
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
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
        request.setAttribute("listSV" , listSinhVien); // object
        request.getRequestDispatcher("Buoi4_TaiNguyen/sinhviens.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        if (url.contains("update")) {
            this.update(request , response);
        } else {
            this.add(request , response);

        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }
}
