package com.sof3011.yennth4.B2_LamQuenVoiForm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
// Ctrl Alt O : để bỏ những import thừa

import java.io.IOException;
// value : Chua duong dan cua trang web
// Duong dan BAT BUOC PHAI BAT DAU / => KHONG LA CHET TOMCAT K BUILD DC (J4 là bắt buộc , J5 thì không cần)
// CTRL ALT O :
// CTRL ALT L : format code
// server vs client => HTTP methods :
// Co 4 loai co ban:
// GET : Hien thi lay ra (READ)
// POST: Them xu ly (CREATE)
// PUT: Update (UPDATE)
// DELETE delete => Xoa (DELETE)
// J4, J5 => CHI DUNG 2 LOAI =>
// GET(Hien thi)
// POST (Xu ly)
// VALUE => Giong Y SI DE BAI
// FE (view clien giao diẹn) => jframe/jsp/html => webapp
// BE(server) => logic => service, repositor, ..
//FE va BE : trao doi bang controller thong qua phuong thuc HTTPMethods

@WebServlet(value = {"/login" , "/ket-qua"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // truyen du lieu tu Servlet - sang JSP  (dùng set Attribute)
        String message = "Hello World";
        request.setAttribute("messageJSP", message);

        // chuyen trang
        // C1 : getRequestDispatcher :
        request.getRequestDispatcher("Buoi2/form-login.jsp")
                .forward(request, response);

        // C2 : sendRedirect : chuyen trang thuan - khong lay duoc du lieu tu JSP
        // response.sendRedirect("form-login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // lay du lieu nhap tu JSP sang Servlet =) getParamsmetter
        String usname = request.getParameter("uname"); // lay gtri o input ( trong nhay kep la name JSP )
        String password = request.getParameter("psw");

        if (usname.trim().isEmpty() || password.trim().isEmpty()) {
            if (usname.trim().isEmpty()) {
                request.setAttribute("validateUSName", "Không được để trống UserName");
            }

            if (password.trim().isEmpty()) {
                request.setAttribute("validatePassword", "Không được để trống Password");
            }

            // Truyền lại dữ liệu người dùng đã nhập vào form
            request.setAttribute("usnameInput", usname);
            request.setAttribute("passwordInput", password);

            // Chuyển hướng lại form
            request.getRequestDispatcher("Buoi2/form-login.jsp").forward(request, response);
            return;
        }

        else {
            if (usname.equals("hangnt169") && password.equals("123")) {
                request.setAttribute("usname", usname);
                request.setAttribute("password", password);
                request.getRequestDispatcher("Buoi2/ket-qua.jsp")
                        .forward(request, response);
            } else {
                request.setAttribute("checkUsPw" , "Sai ten tai khoan or mat khau !!!");
                request.getRequestDispatcher("Buoi2/form-login.jsp")
                        .forward(request, response);
            }
        }
    }
}
