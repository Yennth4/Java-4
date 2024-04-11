package com.sof3011.yennth4.DeThiThu.De1_QLBB.controller;

import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.Ban;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.entity.MoiQuanHe;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.responsitory.BanResponsitory;
import com.sof3011.yennth4.DeThiThu.De1_QLBB.responsitory.MoiQuanHeResponsitory;
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
        "/BanServlet/hien-thi",
        "/BanServlet/add",
        "/BanServlet/remove",
        "/BanServlet/update",
        "/BanServlet/detail",
})
public class BanServlet extends HttpServlet {

    private List<Ban> listBan = new ArrayList<>();
    private List<MoiQuanHe> listMQH = new ArrayList<>();
    private BanResponsitory serviceBan = new BanResponsitory();
    private MoiQuanHeResponsitory serviceMQH = new MoiQuanHeResponsitory();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            hienThi(request , response);
        } else if (url.contains("remove")) {
            deleteBan(request, response);
        } else if (url.contains("detail")) {
            detailBan(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listBan = serviceBan.getAll();
        listMQH = serviceMQH.getAll();
        request.setAttribute("listBan", listBan);
        request.setAttribute("listMQH", listMQH);
        request.getRequestDispatcher("/DeThiThu/De1_QLBB/listBan.jsp").forward(request, response);
    }

    private void detailBan(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.valueOf(request.getParameter("id"));
        Ban ban = serviceBan.getOne(id);
        MoiQuanHe moiQuanHe = serviceMQH.getOne(id);
        request.setAttribute("fillListBan", ban);
        request.setAttribute("mqh", moiQuanHe);
        hienThi(request , response);
    }

    private void deleteBan(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        Ban ban = serviceBan.getOne(id);
        serviceBan.delete(ban);
        response.sendRedirect("/BanServlet/hien-thi");
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            Ban ban = new Ban();
            BeanUtils.populate(ban, request.getParameterMap());

            String errorMa = "";
            String errorTen = "";
            String errorSoThich = "";
            Boolean hasError = false;
            if (ban.getMa().isEmpty()) {
                errorMa = "Ma khong duoc de trong";
                hasError = true;
            }
            if (ban.getTen().isEmpty()) {
                errorTen = "Ten khong duoc de trong";
                hasError = true;
            }
            if (ban.getSoThich().isEmpty()) {
                errorSoThich = "So thich khong duoc de trong";
                hasError = true;
            }
            if (hasError) {
                request.setAttribute("errorMa", errorMa);
                request.setAttribute("errorTen", errorTen);
                request.setAttribute("errorSoThich", errorSoThich);
                request.getRequestDispatcher("/DeThiThu/De1_QLBB/listBan.jsp").forward(request, response);
            } else {
                serviceBan.add(ban);
                response.sendRedirect("/BanServlet/hien-thi");
            }
        }
    }
}
