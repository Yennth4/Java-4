package com.sof3011.yennth4.B7_De1_SanPham.controller;

import com.sof3011.yennth4.B7_De1_SanPham.entity.SanPham;
import com.sof3011.yennth4.B7_De1_SanPham.service.SanPhamService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet({
        "/san-pham/view-all",
        "/san-pham/detail",
        "/san-pham/remove",
        "/san-pham/view-update",
        "/san-pham/add",
        "/san-pham/update",
        "/san-pham/tim-kiem",

})
public class SanPhamServlet extends HttpServlet {

    List<SanPham> listSP = new ArrayList<>();
    SanPhamService service = new SanPhamService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("view-all")) {
            this.hienThi(request , response);
        } else if (url.contains("detail")) {
            this.detail(request , response);
        } else if (url.contains("remove")) {
            this.delete(request , response);
        }  else if (url.contains("view-update")) {
            this.viewUpdate(request , response);
        } else {
            this.search(request , response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("c"));
        service.deleteSP(id);
        response.sendRedirect("/san-pham/view-all");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = service.getAll();
        request.setAttribute("listSP" , listSP);
        request.getRequestDispatcher("/Buoi7/sanpham.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.add(request , response);
        } else {
            this.update(request , response);
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {

    }
}
