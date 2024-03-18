package com.sof3011.yennth4.B6_ValidateTrong;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet( value = {
        "/B6L2Servlet",
        "/B6L2-ket-qua"
})
public class B6L2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Buoi6/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String hang = request.getParameter("hang");
        String mausac = request.getParameter("mausac");
        String conhang = request.getParameter("conhang");
        String mota = request.getParameter("mota");

        if (Integer.valueOf(gia) <= 0 ) {
            request.setAttribute("giaDuong" , "Vui long nhap du gia la so nguyen lon hon 0");
            request.getRequestDispatcher("/Buoi6/form.jsp").forward(request,response);
        }
        if (
                ten != null && !ten.isEmpty() &&
                gia != null && !gia.isEmpty() &&
                hang != null && !hang.isEmpty() &&
                mausac != null && !mausac.isEmpty() &&
                conhang != null && !conhang.isEmpty() &&
                mota != null && !mota.isEmpty()
        ) {
            request.setAttribute("gia" , gia);
            request.setAttribute("hang" , hang);
            request.setAttribute("ten" , ten);
            request.setAttribute("mausac" , mausac);
            request.setAttribute("conhang" , conhang);
            request.setAttribute("mota" , mota);
            request.getRequestDispatcher("/Buoi6/ket-qua.jsp").forward(request,response);
        }
        else {
            request.setAttribute("msg" , "Vui long nhap du thong tin");
            request.getRequestDispatcher("/Buoi6/form.jsp").forward(request,response);
        }
    }
}
