package com.sof3011.yennth4.B9_UID_2Table.controller;

import com.sof3011.yennth4.B9_UID_2Table.entity.SanPham;
import com.sof3011.yennth4.B9_UID_2Table.responsitory.SanPhamResponsitory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {
        "/san-pham/hien-thi1" ,
        "/san-pham/add1" ,
        "/san-pham/view-update1" ,
        "/san-pham/update1" ,
})
public class SanPhamServlet extends HttpServlet {

    private List<SanPham> listSanPham = new ArrayList<>();
    private SanPhamResponsitory service = new SanPhamResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi1")){
            this.hienThi(request,response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSanPham = service.getAll();
        request.setAttribute("listSanPham" , listSanPham);
        request.getRequestDispatcher("/Buoi9/sanpham.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add1")){
            this.addSP(request,response);
        } else {
            this.editSP(request,response);
        }
    }

    private void editSP(HttpServletRequest request, HttpServletResponse response) {

    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) {

    }
}
