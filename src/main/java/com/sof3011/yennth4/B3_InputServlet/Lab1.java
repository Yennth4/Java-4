package com.sof3011.yennth4.B3_InputServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/Lab1" , ""})
public class Lab1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // trang hien thi de lay du lieu
        request.getRequestDispatcher("Buoi3/Lab1/form.jsp")
                .forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // xu ly
        // lay gtri tu form sang servlet
        Double donGia = Double.valueOf(request.getParameter("donGia"));
        Double soLuong = Double.valueOf(request.getParameter("soLuong"));
        Double giamGia = Double.valueOf(request.getParameter("giamGia"));
        Double tinhGiaTri = soLuong * donGia - giamGia;
        // day du lieu moi tu servlet len form moi
        request.setAttribute("donGia" , donGia);
        request.setAttribute("soLuong" , soLuong);
        request.setAttribute("giamGia" , giamGia);
        request.setAttribute("tinhGiaTri" , tinhGiaTri);
        request.getRequestDispatcher("Buoi3/Lab1/ket-qua.jsp")
                .forward(request, response);
    }
}