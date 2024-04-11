package com.sof3011.yennth4.DeThiThu.De6_QLSP.controller;

import com.sof3011.yennth4.DeThiThu.De6_QLSP.entity.LoaiSanPham;
import com.sof3011.yennth4.DeThiThu.De6_QLSP.entity.SanPham;
import com.sof3011.yennth4.DeThiThu.De6_QLSP.repository.LoaiSanPhamResponsitory;
import com.sof3011.yennth4.DeThiThu.De6_QLSP.repository.SanPhamResponsitory;
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
        "/san-pham/hien-thi2",
        "/san-pham/add2",
        "/san-pham/detail2",
        "/san-pham/update2",
        "/san-pham/remove2",
})
public class SanPhamServlet extends HttpServlet {

    List<SanPham> listSP = new ArrayList<>();
    List<LoaiSanPham> listLoaiSP = new ArrayList<>();
    SanPhamResponsitory serviceSP = new SanPhamResponsitory();
    LoaiSanPhamResponsitory serviceLoaiSP = new LoaiSanPhamResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            hienThi(request, response);
        } else if (url.contains("remove")) {
            removeSP(request, response);
        } else {
            detail(request, response);
        }
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            addSP(request, response);
        } else {
            updateSP(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listSP = serviceSP.getAll();
        listLoaiSP = serviceLoaiSP.getAll();
        request.setAttribute("listSP", listSP);
        request.setAttribute("listLoaiSP", listLoaiSP);
        request.getRequestDispatcher("/DeThiThu/De6_QLSP/listSP.jsp").forward(request, response);
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        SanPham sanPham = serviceSP.getOneById(id);
        request.setAttribute("sp", sanPham);
        hienThi(request, response);
    }

    private void removeSP(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        SanPham sanPham = serviceSP.getOneById(id);
        serviceSP.delete(sanPham);
        response.sendRedirect("/san-pham/hien-thi2");
    }

    private void updateSP(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        SanPham sanPham = new SanPham();
        BeanUtils.populate(sanPham, request.getParameterMap());
        serviceSP.update(sanPham);
        hienThi(request, response);
    }

    private void addSP(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        SanPham sanPham = new SanPham();
        BeanUtils.populate(sanPham, request.getParameterMap());
        serviceSP.add(sanPham);
        response.sendRedirect("/san-pham/hien-thi2");
    }
}
