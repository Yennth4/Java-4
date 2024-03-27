package com.sof3011.yennth4.Asm1.controller;

import com.sof3011.yennth4.Asm1.entity.Movie;
import com.sof3011.yennth4.Asm1.service.MovieService;
import com.sof3011.yennth4.B7_De1_SanPham.entity.SanPham;
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
        "/movie/hien-thi",
        "/movie/view-update",
        "/movie/view-add",
        "/movie/detail",
        "/movie/remove",
        "/movie/add",
        "/movie/update",
})
public class MovieServlet extends HttpServlet {

    List<Movie> listMovie = new ArrayList<>();
    MovieService serviceMovie = new MovieService();
    List<String> messError = new ArrayList<>();
    Movie movie = new Movie();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getRequestURI();
        if (url.contains("hien-thi")) {
            this.hienThi(request, response);
        } else if (url.contains("view-update")) {
            this.viewUpdate(request, response);
        } else if (url.contains("view-add")) {
            this.viewAdd(request, response);
        } else if (url.contains("detail")) {
            this.detail(request, response);
        } else {
            this.remove(request, response);
        }
    }


    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = request.getRequestURI();
        if (url.contains("update")) {
            this.update(request, response);
        } else {
            this.add(request, response);
        }
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        Movie movie = new Movie();
        BeanUtils.populate(movie,request.getParameterMap());

        // Kiểm tra và xác thực dữ liệu
        Map<String, String> errorMessages = validateRequiredFields(movie);

        if (!errorMessages.isEmpty()) {
            request.setAttribute("errorMessages", errorMessages);
            viewAdd(request, response);
            return;
        }
        serviceMovie.addMovie(movie);
        response.sendRedirect("/movie/hien-thi");
    }

    private void update(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ServletException {
        Movie movie = new Movie();
        BeanUtils.populate(movie,request.getParameterMap());
        Map<String, String> errorMessages = validateRequiredFields(movie);

        if (!errorMessages.isEmpty()) {
            request.setAttribute("errorMessages", errorMessages);
            viewUpdate(request, response);
            return;
        }
        serviceMovie.updateMovie(movie);
        response.sendRedirect("/movie/hien-thi");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = request.getParameter("c");
        serviceMovie.deleteMovie(id);
        response.sendRedirect("/movie/hien-thi");
    }

    private void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("a");
        Movie movie = serviceMovie.detailMovie(id);
        request.setAttribute("listMovie" , movie);
        request.getRequestDispatcher("/Asm/Movie/detail-movie.jsp").forward(request,response);
    }

    private void viewAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/Asm/Movie/add-movie.jsp").forward(request,response);
    }

    private void viewUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("b");
        Movie movie = serviceMovie.detailMovie(id);
        request.setAttribute("listMovie" , movie);
        request.getRequestDispatcher("/Asm/Movie/update-movie.jsp").forward(request,response);
    }

    private void hienThi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        listMovie = serviceMovie.getAllMovie();
        request.setAttribute("listMovie", listMovie);
        request.getRequestDispatcher("/Asm/Movie/movie.jsp").forward(request, response);
    }

    private Map<String, String> validateRequiredFields(Movie movie) {
        Map<String, String> errorMessages = new HashMap<>();

        // Kiểm tra các trường bắt buộc: id, title, poster
        if (movie.getId() == null || movie.getId().isEmpty()) {
            errorMessages.put("id", "Vui long nhap Id.");
        }
        if (movie.getTitle() == null || movie.getTitle().isEmpty()) {
            errorMessages.put("title", "Vui long nhap Title.");
        }
        if (movie.getPoster() == null || movie.getPoster().isEmpty()) {
            errorMessages.put("poster", "Vui long nhap URL cho poster.");
        }

        return errorMessages;
    }

}
