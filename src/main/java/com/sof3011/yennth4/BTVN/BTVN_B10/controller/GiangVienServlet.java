package com.sof3011.yennth4.BTVN.BTVN_B10.controller;

import com.sof3011.yennth4.BTVN.BTVN_B10.entity.GiangVien;
import com.sof3011.yennth4.BTVN.BTVN_B10.repository.GiangVienRepository;
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

@WebServlet(name = "GiangVienServlet", value = {
        "/giang-vien/hien-thi-tat-ca",
        "/giang-vien/detail",
        "/giang-vien/remove",
        "/giang-vien/update",
        "/giang-vien/view-update",
        "/giang-vien/tim-kiem",
        "/giang-vien/add"
})
public class GiangVienServlet extends HttpServlet {

    private GiangVienRepository giangVienRepository = new GiangVienRepository();
    private List<GiangVien> giangViens = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("hien-thi-tat-ca")) {
            this.hienThiDanhSachGiangVien(request, response);

        } else if (uri.contains("detail")) {
            this.detailGiangVien(request, response);

        } else if (uri.contains("remove")) {
            this.removeGiangVien(request, response);

        } else if (uri.contains("tim-kiem")) {
            this.searchGiangVien(request, response);

        } else {

            this.viewUpdateGiangVien(request, response);
        }
    }

    private void viewUpdateGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        long id = Long.valueOf(request.getParameter("update"));
        GiangVien gv = giangVienRepository.getOne(id);
        request.setAttribute("gvfill", gv);
        request.getRequestDispatcher("/BTVN/Buoi6/update-giangvien.jsp").forward(request, response);
    }

    private void searchGiangVien(HttpServletRequest request, HttpServletResponse response) {
    }

    private void removeGiangVien(HttpServletRequest request, HttpServletResponse response) throws IOException {


        long id = Long.valueOf(request.getParameter("deleteMa"));
        GiangVien giangVien = giangVienRepository.getOne(id);
        giangVienRepository.delete(giangVien);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");

    }

    private void detailGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        long id = Long.valueOf(request.getParameter("detail"));
        GiangVien gv = giangVienRepository.getOne(id);
        request.setAttribute("gvfill", gv);
        giangViens = giangVienRepository.getAll();
        request.setAttribute("lists", giangViens);
        request.getRequestDispatcher("/BTVN/Buoi6/giang-vien-form.jsp").forward(request, response);
    }

    private void hienThiDanhSachGiangVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        giangViens = giangVienRepository.getAll();
        request.setAttribute("lists", giangViens);
        request.getRequestDispatcher("/BTVN/Buoi6/giang-vien-form.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("update")) {
            this.updateGiangVien(request, response);
        } else {
            this.addGiangVien(request, response);
        }
    }

    private void addGiangVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {

        GiangVien gv = new GiangVien();
        BeanUtils.populate(gv, request.getParameterMap());
        if (isValidGiangVien(gv)) {
            giangVienRepository.add(gv);
            response.sendRedirect("/giang-vien/hien-thi-tat-ca");

        } else {
            if (gv.getMaGV() == null || gv.getMaGV().isEmpty()) {
                request.setAttribute("errorma", "Mã không được trống");
            }
            if (gv.getTen() == null || gv.getTen().isEmpty()) {
                request.setAttribute("errorname", "Tên không được trống");
            }
            if (gv.getTuoi() <= 0) {
                request.setAttribute("errorage", "Tuổi không được trống");
            }

            if (gv.getQueQuan() == null || gv.getQueQuan().isEmpty()) {
                request.setAttribute("erroraddress", "Địa chỉ không được trống");
            }
            giangViens = giangVienRepository.getAll();
            request.setAttribute("lists", giangViens);
            request.getRequestDispatcher("/BTVN/Buoi6/giang-vien-form.jsp").forward(request, response);
        }


    }
    private boolean isValidGiangVien(GiangVien gv) {
        if (gv.getMaGV() == null || gv.getMaGV().isEmpty() ||
                gv.getTen() == null || gv.getTen().isEmpty() ||
                gv.getQueQuan() == null || gv.getQueQuan().isEmpty() ||
                gv.getTuoi() <= 25) {
            return false;
        }
        return true;
    }
    private void updateGiangVien(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {

        GiangVien gv = new GiangVien();
        BeanUtils.populate(gv, request.getParameterMap());
        giangVienRepository.update(gv);
        response.sendRedirect("/giang-vien/hien-thi-tat-ca");
    }
}
