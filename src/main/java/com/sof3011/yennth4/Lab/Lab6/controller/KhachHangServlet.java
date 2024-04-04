package com.sof3011.yennth4.Lab.Lab6.controller;

import com.sof3011.yennth4.Lab.Lab6.entity.KhachHang;
import com.sof3011.yennth4.Lab.Lab6.responsitory.KhachHangResponsitory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(value = {
        "/KhachHangServlet" ,
        "/KhachHangServlet/update" ,
})
public class KhachHangServlet extends HttpServlet {

    KhachHangResponsitory service = new KhachHangResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<KhachHang> listKH = service.getAll();
        request.setAttribute("listKH" , listKH);
        request.getRequestDispatcher("/Lab/Lab6/khachhang.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
