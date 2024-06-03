package com.sof3011.yennth4.DeThiThu.De2_QLBB.controller;

import com.sof3011.yennth4.DeThiThu.De2_QLBB.entity.Ban;
import com.sof3011.yennth4.DeThiThu.De2_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De2_QLBB.repository.BanResponsitory;
import com.sof3011.yennth4.DeThiThu.De2_QLBB.repository.MoiQuanHeResponsitory;
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
        "/BanServlet/hien-thi",
        "/BanServlet/add",
        "/BanServlet/remove",
        "/BanServlet/detail",
        "/BanServlet/update",
})
public class BanServlet extends HttpServlet {

    List<Ban> listBan = new ArrayList<>();
    List<MoiQuanHe> listMqh = new ArrayList<>();
    BanResponsitory serviceBan = new BanResponsitory();
    MoiQuanHeResponsitory serviceMqh = new MoiQuanHeResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            hienThi(request, response);
        } else if (url.contains("detail")) {
            detailBan(request, response);
        } else {
            removeBan(request, response);
        }
    }

    private void detailBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Ban ban = serviceBan.getOne(id);
        request.setAttribute("ban", ban);
        hienThi(request, response);
    }

    private void removeBan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Ban ban = serviceBan.getOne(id);
        serviceBan.xoa(ban);
        response.sendRedirect("/BanServlet/hien-thi");
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listBan = serviceBan.getAll();
        listMqh = serviceMqh.getAll();
        request.setAttribute("listBan", listBan);
        request.setAttribute("listMqh", listMqh);
        request.getRequestDispatcher("/DeThiThu/De2_QLBB/listBan.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            addBan(request, response);
        } else {
            editBan(request, response);
        }
    }

    private void editBan(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        Ban ban = new Ban();
        BeanUtils.populate(ban, request.getParameterMap());
        if (validate(ban , request , response)) {
            serviceBan.sua(ban);
            hienThi(request, response);
        }
    }

    private void addBan(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Ban ban = new Ban();
        BeanUtils.populate(ban, request.getParameterMap());
        serviceBan.them(ban);
        response.sendRedirect("/BanServlet/hien-thi");
    }

    public boolean validate(Ban ban, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errorMa = "";
        String errorTen = "";
        String errorSoThich = "";

        boolean hasError = false;

        if (ban.getMa().isEmpty()) {
            errorMa = "Mã không được trống";
            hasError = true;
        }
        if (ban.getTen().isEmpty()) {
            errorTen = "Tên không được trống";
            hasError = true;
        }
        if (ban.getSoThich().isEmpty()) {
            errorSoThich = "Sở thích không được trống";
            hasError = true;
        }

        if (hasError) {
            // Đặt trạng thái lỗi vào thuộc tính của yêu cầu
            request.setAttribute("errorMa", errorMa);
            request.setAttribute("errorTen", errorTen);
            request.setAttribute("errorSoThich", errorSoThich);
            // Đặt trạng thái lỗi vào thuộc tính của yêu cầu để sử dụng trong JS
            request.setAttribute("errorStatus", "true");
            request.getRequestDispatcher("/DeThiThu/De2_QLBB/listBan.jsp").forward(request, response);
        } else {
            // Nếu không có lỗi, đặt trạng thái lỗi thành false
            request.setAttribute("errorStatus", "false");
        }
        return hasError;
    }

}
