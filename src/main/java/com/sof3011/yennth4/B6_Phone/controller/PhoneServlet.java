package com.sof3011.yennth4.B6_Phone.controller;

import com.sof3011.yennth4.B6_Phone.entity.Phone;
import com.sof3011.yennth4.B6_Phone.sevice.PhoneService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {
        "/phone/hien-thi",
        "/phone/add"
})
public class PhoneServlet extends HttpServlet {

    List<Phone> listPhone = new ArrayList<>();
    PhoneService service = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThi(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listPhone = service.getAll();
        request.setAttribute("listPhone", listPhone);
        request.getRequestDispatcher("/Buoi6/phone.jsp").forward(request, response);
    }

    private void addPhone(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        Phone phone = new Phone();
        BeanUtils.populate(phone, request.getParameterMap());
        service.addPhone(phone);
        response.sendRedirect("/phone/hien-thi");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.addPhone(request, response);
        }

    }
}
/*
        String ten = request.getParameter("ten");
        String gia = request.getParameter("gia");
        String hang = request.getParameter("hang");
        String mausac = request.getParameter("mausac");
        String conhang = request.getParameter("conhang");
        String mota = request.getParameter("mota");

        if (Integer.valueOf(gia) <= 0 ) {
            request.setAttribute("giaDuong" , "Vui long nhap du gia la so nguyen lon hon 0");
            request.getRequestDispatcher("/Buoi6/phone.jsp").forward(request,response);
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
            request.getRequestDispatcher("/Buoi6/phone.jsp").forward(request,response);
        }
        */

