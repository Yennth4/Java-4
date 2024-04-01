package com.sof3011.yennth4.B8_Hibernate.controller;
import com.sof3011.yennth4.B8_Hibernate.entity.Category;
import com.sof3011.yennth4.B8_Hibernate.service.CategoryService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = {
        "/category/hienthi",
        "/category/add",
        "/category/view-add",
        "/category/detail",
        "/category/update",
        "/category/view-update",
        "/category/remove",
})
public class CategoryServlet extends HttpServlet {

    private List<Category> listCategory = new ArrayList<>();
    private CategoryService service = new CategoryService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hienthi")) {
            this.hienThi(request, response);
        } else if (url.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (url.contains("detail")) {
            this.detail(request, response);
        } else if (url.contains("remove")) {
            this.remove(request, response);
        } else {
            this.viewUpdate(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("add")) {
            this.add(request, response);
        } else {
            this.update(request, response);
        }
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listCategory = service.getAll();
        request.setAttribute("lists" , listCategory);
        request.getRequestDispatcher("/Buoi8/category/category-list.jsp").forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id  = Long.valueOf(request.getParameter("c"));
        Category category = service.getOne(id);
        service.deleteCategory(category);
        response.sendRedirect("/category/hienthi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) {

    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) {
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) {
    }

    private void add(HttpServletRequest request, HttpServletResponse response) {
    }

}
