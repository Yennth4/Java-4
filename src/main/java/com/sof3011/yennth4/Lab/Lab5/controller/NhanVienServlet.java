package com.sof3011.yennth4.Lab.Lab5.controller;

import com.sof3011.yennth4.Lab.Lab5.entity.NhanVien;
import com.sof3011.yennth4.Lab.Lab5.responsitory.NhanVienService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {
        "/NhanVienServlet/hienThi",
        "/NhanVienServlet/add",
        "/NhanVienServlet/remove",
        "/NhanVienServlet/detail",
        "/NhanVienServlet/update",
})
public class NhanVienServlet extends HttpServlet {

    private List<NhanVien> listNV = new ArrayList<>();
    private NhanVienService service = new NhanVienService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hienThi")) {
            listNV = service.getAll();
            request.setAttribute("listNV", listNV);
            request.getRequestDispatcher("/Lab/Lab5/nhanvien.jsp").forward(request, response);
        } else {
                String ma = request.getParameter("c");
                NhanVien nv = service.getOne(ma);
                service.deleteNhanVien(nv);
                response.sendRedirect("/NhanVienServlet/hienThi");
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        NhanVien nv = new NhanVien();
        BeanUtils.populate(nv, request.getParameterMap());
        service.addNhanVien(nv);
        response.sendRedirect("/NhanVienServlet/hienThi");
    }
}
