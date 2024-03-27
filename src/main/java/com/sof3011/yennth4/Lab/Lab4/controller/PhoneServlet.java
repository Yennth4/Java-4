package com.sof3011.yennth4.Lab.Lab4.controller;

import com.sof3011.yennth4.Lab.Lab4.entity.Phone;
import com.sof3011.yennth4.Lab.Lab4.service.PhoneService;
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
        "/phone/add",
        "/phone/remove",
        "/phone/update",
        "/phone/view-update",
        "/phone/detail",
})
public class PhoneServlet extends HttpServlet {

    List<Phone> listPhone = new ArrayList<>();
    PhoneService service = new PhoneService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThi(request , response);
        } else if (url.contains("remove")) {
            this.remove(request , response);
        } else if (url.contains("view-update")) {
            this.viewUpdate(request , response);
        } else {
            this.detail(request , response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.add(request , response);
        } else if (url.contains("update")) {
            this.update(request , response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listPhone = service.getAll();
        request.setAttribute("listPhone" , listPhone);
        request.getRequestDispatcher("/Lab/Lab4/form.jsp").forward(request,response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Phone phone = new Phone();
        BeanUtils.populate(phone , request.getParameterMap());
        service.addPhone(phone);
        response.sendRedirect("/phone/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("a"));
        Phone listPhone = service.detailPhone(id);
        request.setAttribute("listPhone" , listPhone);
        request.getRequestDispatcher("/Lab/Lab4/detail-phone.jsp").forward(request,response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("c"));
        service.deletePhone(id);
        response.sendRedirect("/phone/hien-thi");
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("b"));
        Phone listPhone = service.detailPhone(id);
        request.setAttribute("listPhone" , listPhone);
        request.getRequestDispatcher("/Lab/Lab4/update-phone.jsp").forward(request,response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        Phone phone = new Phone();
        BeanUtils.populate(phone , request.getParameterMap());
        service.updatePhone(phone);
        response.sendRedirect("/phone/hien-thi");
    }

}
