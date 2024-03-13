package com.sof3011.yennth4.BTVN.Buoi4_GiangVien.controller;

import com.sof3011.yennth4.BTVN.Buoi4_GiangVien.entity.GiangVien;
import com.sof3011.yennth4.BTVN.Buoi4_GiangVien.service.GiangVienService;
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
        "/giang-vien/hien-thi" , // GET
        "/giang-vien/search" , // GET
        "/giang-vien/giang-vien-nu" , // GET LOC
        "/giang-vien/remove" , // GET
        "/giang-vien/detail" , // GET
        "/giang-vien/view-update" , // GET
        "/giang-vien/update" , // POST
        "/giang-vien/view-add" , // GET
        "/giang-vien/add" // POST
})
public class GiangVienServlet extends HttpServlet {

    private GiangVienService service = new GiangVienService();
    private List<GiangVien> listGiangVien = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       // lay duong link
        String url = request.getRequestURI();

        // so sanh duong link voi chuc nang cua no
        if (url.contains("hien-thi")) {
            this.hienThi(request , response);
        }
        else if (url.contains("search")) {
            this.search(request , response);
        }
        else if (url.contains("giang-vien-nu")) {
            this.locGiangVienNu(request , response);
        }
        else if (url.contains("remove")) {
            this.remove(request , response);
        }
        else if (url.contains("detail")) {
            this.detail(request , response);
        }
        else if (url.contains("view-update")) {
            this.viewUpdate(request , response);
        }
        else {
            this.viewAdd(request , response);
        }

    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String tenSearch = request.getParameter("tenSearch");
    }

    private void locGiangVienNu(HttpServletRequest request, HttpServletResponse response) {
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) {
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/BTVN/Buoi4/add-giang-vien.jsp")
                .forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listGiangVien = service.getAll();
        request.setAttribute("listGV" , listGiangVien);
        request.getRequestDispatcher("/BTVN/Buoi4/giangvien.jsp")
                .forward(request,response);

    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("update")) {
            this.update(request , response);
        }
        else {
            this.add(request , response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        GiangVien giangVien = new GiangVien();
        BeanUtils.populate(giangVien , request.getParameterMap());
        service.addGV(giangVien);
        response.sendRedirect("/giang-vien/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }
}
