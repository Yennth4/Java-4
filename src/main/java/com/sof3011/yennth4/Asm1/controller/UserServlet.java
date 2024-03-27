package com.sof3011.yennth4.Asm1.controller;

import com.sof3011.yennth4.Asm1.entity.User;
import com.sof3011.yennth4.Asm1.service.UserService;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(value = {
        "/user/hien-thi",
        "/user/view-add",
        "/user/add",
        "/user/view-update",
        "/user/update",
        "/user/detail",
        "/user/remove"
})

public class UserServlet extends HttpServlet {

    List<User> listUser = new ArrayList<>();
    UserService serviceUser = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (url.contains("detail")) {
            this.detail(request, response);
        } else if (url.contains("remove")) {
            this.remove(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdate(request, response);
        } else {
            this.viewAdd(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listUser = serviceUser.getAllUser();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("/Asm/User/user.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("c");
        serviceUser.deleteUser(id);
        response.sendRedirect("/user/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("a");
        User user = serviceUser.detailUser(id);
        request.setAttribute("listUser", user);
        request.getRequestDispatcher("/Asm/User/detail-user.jsp").forward(request, response);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("b");
        User user = serviceUser.detailUser(id);
        request.setAttribute("listUser", user);
        request.getRequestDispatcher("/Asm/User/update-user.jsp").forward(request, response);
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        User user = new User();
        BeanUtils.populate(user, request.getParameterMap());
        request.setAttribute("form" , user);
        Map<String, String> errorMessages = validateUser(user);

        if (!errorMessages.isEmpty()) {
            request.setAttribute("errorMessages", errorMessages);
            viewUpdate(request, response);
            return;
        }
        serviceUser.updateUser(user);
        response.sendRedirect("/user/hien-thi");
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Asm/User/add-user.jsp").forward(request, response);
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        User user = new User();
        BeanUtils.populate(user, request.getParameterMap());

        Map<String, String> errorMessages = validateUser(user);

        if (!errorMessages.isEmpty()) {
            request.setAttribute("errorMessages", errorMessages);
            viewAdd(request, response);
            return;
        }
        serviceUser.addUser(user);
        response.sendRedirect("/user/hien-thi");
    }

    private Map<String , String> validateUser (User user) {
        Map<String , String> errorMessae = new HashMap<>();

        if (user.getId() == null || user.getId().trim().isEmpty()) {
            errorMessae.put("id" , "Vui long nhap id");
        }
        if (user.getEmail() == null || user.getEmail().trim().isEmpty()) {
            errorMessae.put("email" , "Vui long nhap email");
        }
        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            errorMessae.put("password" , "Vui long nhap password");
        } else {
            if (user.getPassword().trim().length() < 6) {
                errorMessae.put("password", "Password phai lon hon hoac bang 6");
            }
            if (!user.getPassword().trim().matches(".*\\d.*")) {
                errorMessae.put("password", "Password phai chua 1 chu so");
            }
            if (!user.getPassword().trim().matches(".*[a-zA-Z].*")) {
                errorMessae.put("password", "Password chua it nhat 1 chu cai.");
            }
        }
        if (user.getFullname() == null || user.getFullname().trim().isEmpty()) {
            errorMessae.put("fullname" , "Vui long nhap fullname");
        }
        if (user.getPassword().trim().length() <= 6) {
            errorMessae.put("password1" , "Vui long nhap password co do dai lon hon hoac bang 6");
        }
        return errorMessae;
    }
}
