package com.sof3011.yennth4.DeThiThu.De9_QLNV.controller;

import com.sof3011.yennth4.DeThiThu.De9_QLNV.entity.ChucVu;
import com.sof3011.yennth4.DeThiThu.De9_QLNV.entity.NhanVien;
import com.sof3011.yennth4.DeThiThu.De9_QLNV.responsitory.ChucVuResponsitory;
import com.sof3011.yennth4.DeThiThu.De9_QLNV.responsitory.NhanVienResponsitory;
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
        "/nhan-vien/hien-thi",
        "/nhan-vien/add",
        "/nhan-vien/detail",
        "/nhan-vien/update",
        "/nhan-vien/remove",
})

public class NhanVienServlet extends HttpServlet {

    List<NhanVien> listNhanVien = new ArrayList<>();
    List<ChucVu> listChucVu = new ArrayList<>();
    NhanVienResponsitory serviceNhanVien = new NhanVienResponsitory();
    ChucVuResponsitory serviceChucVu = new ChucVuResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            hienThi(request, response);
        } else if (url.contains("detail")) {
            detail(request, response);
        } else {
            remove(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            add(request, response);
        } else {
            update(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listNhanVien = serviceNhanVien.getAll();
        listChucVu = serviceChucVu.getAll();
        request.setAttribute("listNhanVien", listNhanVien);
        request.setAttribute("listChucVu", listChucVu);
        request.getRequestDispatcher("/DeThiThu/De9_QLNV/listNhanVien.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        NhanVien nhanVien = serviceNhanVien.getOne(id);
        request.setAttribute("nv", nhanVien);
        hienThi(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        NhanVien nhanVien = serviceNhanVien.getOne(id);
        serviceNhanVien.xoa(nhanVien);
        response.sendRedirect("/nhan-vien/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.populate(nhanVien, request.getParameterMap());
        if (!validate(nhanVien, request, response)) {
            serviceNhanVien.sua(nhanVien);
            hienThi(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        NhanVien nhanVien = new NhanVien();
        BeanUtils.populate(nhanVien, request.getParameterMap());
        if (!validate(nhanVien, request, response)) {
            serviceNhanVien.add(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }
    }

    private boolean validate(NhanVien nhanVien, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String erMa = "";
        String erTen = "";
        String erMatKhau = "";
        Boolean isEr = false;
        if (nhanVien.getMa().isEmpty() || nhanVien.getTen().isEmpty() || nhanVien.getMatKhau().isEmpty()) {
            erMa = erTen = erMatKhau = "Khong duoc de trong";
            isEr = true;
        }
        if (isEr) {
            request.setAttribute("erMa" , erMa);
            request.setAttribute("erTen" , erTen);
            request.setAttribute("erMatKhau" , erMatKhau);
            request.getRequestDispatcher("/DeThiThu/De9_QLNV/listNhanVien.jsp").forward(request, response);
        }
        return isEr;
    }
}
