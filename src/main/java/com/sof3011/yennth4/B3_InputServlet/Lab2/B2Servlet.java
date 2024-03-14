package com.sof3011.yennth4.B3_InputServlet.Lab2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(value = {
        "/B2Servlet",
        "/B2L2-ket-qua"
})
public class B2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Buoi3/Lab2/B2/form.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String usname = request.getParameter("usname");
        request.setAttribute("usname" , usname);

        String pwd = request.getParameter("pwd");
        request.setAttribute("pwd" , pwd);

        Boolean gioitinh = Boolean.valueOf(request.getParameter("gioitinh"));
        request.setAttribute("gioitinh" , gioitinh);

        Boolean xacNhan = Boolean.valueOf(request.getParameter("xacNhan")) != null;
        request.setAttribute("xacNhan" , xacNhan);

        // check box group
        String[] sothich = request.getParameterValues("sothich");
        if (sothich != null && sothich.length > 0){
            request.setAttribute("sothich" , String.join(" , " , sothich));
        } else {
            request.setAttribute("sothich" , "Khong co so thich");
        }

        String quocgia = request.getParameter("quocgia");
        request.setAttribute("quocgia" , quocgia);

        String note = request.getParameter("note");
        request.setAttribute("note" , note);

        request.getRequestDispatcher("/Buoi3/Lab2/B2/ket-qua.jsp").forward(request,response);
    }
}
