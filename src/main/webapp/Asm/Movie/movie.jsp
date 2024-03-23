<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Danh sash movie</title>
</head>
<body>
<h2 class="text-info text-center mb-3 mt-3">Danh sach movie</h2>
<a href="/movie/view-add"><button class="btn btn-success mb-3">Add</button></a>
<table class="table table-hover table-bordered">
        <thead class="text-center">
            <th>ID</th>
            <th>Title</th>
            <th>Description</th>
            <th>Active</th>
            <th>Poster</th>
            <th>Hanh dong</th>
        </thead>

        <tbody>
        <c:forEach items="${listMovie}" var="movie">
            <tr>
                <td>${movie.id}</td>
                <td>${movie.title}</td>
                <td>${movie.description}</td>
                <td>${movie.active ? "Co" : "Khong"}</td>
                <td>${movie.poster}</td>
                <td class="text-center">
                    <a href="/movie/detail?a=${movie.id}">
                        <button class="btn btn-secondary">Detail</button>
                    </a>
                    <a href="/movie/view-update?b=${movie.id}">
                        <button class="btn btn-warning">Update</button>
                    </a>
                    <a href="/movie/remove?c=${movie.id}" onclick="return confirmDelete();">
                        <button class="btn btn-outline-danger">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
</table>
</body>
<script>
    function confirmDelete() {
        return confirm("Ban co chac chan muon xoa ?");
    }
</script>
</html>
