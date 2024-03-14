package com.sof3011.yennth4.B3_InputServlet.Lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {
        "/B1Servlet",
        "/chu-vi",
        "/dien-tich",
})
public class B1Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Buoi3/Lab2/B1/form.jsp").forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double a = Double.valueOf(request.getParameter("a"));
        Double b = Double.valueOf(request.getParameter("b"));
        Double c = Double.valueOf(request.getParameter("c"));
        if (a >= b + c || a + b <= c || b >= a + c){
            request.setAttribute("tbLoi" , "Khong phai tam giac");
        } else {
            if (request.getRequestURI().contains("chu-vi")){
                Double chuVi = a + b + c;
                request.setAttribute("chuvi" , chuVi);
            } else {
                Double dienTich = a * b * c;
                request.setAttribute("dientich" , dienTich);
            }
        }
        request.getRequestDispatcher("/Buoi3/Lab2/B1/form.jsp").forward(request , response);
    }
}
