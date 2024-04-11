package com.sof3011.yennth4.DeThiThu.De1_QLBB.controller;

import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.Ban;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.repository.BanResponsitory;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.repository.MoiQuanHeResponsitory;
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
        "/ban/hien-thi",
        "/ban/add",
        "/ban/update",
        "/ban/detail",
        "/ban/remove",

})
public class BanServlet extends HttpServlet {

    List<Ban> listBan = new ArrayList<>();
    BanResponsitory service = new BanResponsitory();
    List<MoiQuanHe> listMqh = new ArrayList<>();
    MoiQuanHeResponsitory serviceMqh = new MoiQuanHeResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            hienThi(request, response);
        } else if (url.contains("remove")) {
            removeBan(request, response);
        } else {
            detailBan(request, response);
        }
    }

    private void detailBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Ban ban = service.getOneByID(id);
        request.setAttribute("ban", ban);
        hienThi(request, response);
    }

    private void removeBan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Ban ban = service.getOneByID(id);
        service.xoa(ban);
        response.sendRedirect("/ban/hien-thi");
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listBan = service.getAll();
        request.setAttribute("listBan", listBan);
        listMqh = serviceMqh.getAll();
        request.setAttribute("listMqh", listMqh);
        request.getRequestDispatcher("/DeThiThu/De1_QLBB/listBan.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            themBan(request, response);
        } else {
            updateBan(request, response);
        }
    }

    private void updateBan(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        Ban ban = new Ban();
        BeanUtils.populate(ban, request.getParameterMap());
        if (!validate(ban, request, response)) {
            service.sua(ban);
            response.sendRedirect("/ban/hien-thi");
        }
    }

    private void themBan(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Ban ban = new Ban();
        BeanUtils.populate(ban, request.getParameterMap());
        service.add(ban);
        response.sendRedirect("/ban/hien-thi");
    }

    public boolean validate(Ban ban, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String errorMa = "";
        String errorTen = "";
        String errorSoThich = "";

        boolean hasError = false;

        if (ban.getMa().isEmpty()) {
            errorMa = "Ma khong duoc trong";
            hasError = true;
        }
        if (ban.getTen().isEmpty()) {
            errorTen = "Ten khong duoc trong";
            hasError = true;
        }
        if (ban.getSoThich().isEmpty()) {
            errorSoThich = "So thich khong duoc trong";
            hasError = true;
        }

        if (hasError) {
            request.setAttribute("errorMa", errorMa);
            request.setAttribute("errorTen", errorTen);
            request.setAttribute("errorSoThich", errorSoThich);
            request.getRequestDispatcher("/DeThiThu/De1_QLBB/listBan.jsp").forward(request, response);
        }
        return hasError;
    }
}
