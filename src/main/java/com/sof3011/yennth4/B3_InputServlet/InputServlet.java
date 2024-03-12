package com.sof3011.yennth4.B3_InputServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {"/InputServlet" , "/ket-qua1" })
public class InputServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Buoi3/Input/form.jsp")
                .forward(request , response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoTen = request.getParameter("hoten");
        request.setAttribute("hoten" , hoTen);

        Boolean gioiTinh = Boolean.valueOf(request.getParameter("gioiTinh"));
        request.setAttribute("gioiTinh" , gioiTinh);

        String password = request.getParameter("password");
        request.setAttribute("password" , password);

        String moTa = request.getParameter("mota");
        request.setAttribute("mota" , moTa);

        // check box chọn nhiều thì khai báo trong 1 chuỗi và dùng getParameterValues

        String[] soThichValues = request.getParameterValues("sothich");
        if (soThichValues != null && soThichValues.length > 0) {
            request.setAttribute("sothich", String.join(" , ", soThichValues));
        } else {
            request.setAttribute("sothich", ""); // Set an empty string if no hobbies are selected
        }

        String queQuan = request.getParameter("quequan");
        request.setAttribute("quequan", queQuan);

        Boolean chb1 = Boolean.valueOf(request.getParameter("chb1")) != null;
        request.setAttribute("chb1", chb1);

        request.getRequestDispatcher("Buoi3/Input/ket-qua.jsp")
                .forward(request , response);

    }
}
