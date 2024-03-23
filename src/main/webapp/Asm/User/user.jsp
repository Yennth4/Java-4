<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sash user</title>
</head>
<body>
<h2 class="text-info text-center mb-3 mt-3">Danh sach user</h2>
<a href="/user/view-add"><button class="btn btn-success mb-3">Add</button></a>
<table class="table table-hover table-bordered">

    <thead class="text-center">
        <th>ID</th>
        <th>Email</th>
        <th>Password</th>
        <th>Fullname</th>
        <th>Admin</th>
        <th>Hanh dong</th>
    </thead>

    <tbody>
    <c:forEach items="${listUser}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.fullname}</td>
            <td>${user.admin ? "Nhan vien" : "Quan ly"}</td>
            <td class="text-center">
                <a href="/user/detail?a=${user.id}">
                    <button class="btn btn-secondary">Detail</button>
                </a>
                <a href="/user/view-update?b=${user.id}">
                    <button class="btn btn-warning">Update</button>
                </a>
                <a href="/user/remove?c=${user.id}" onclick="return confirmDelete();">
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
        return confirm("Ban co chac chan muon xoa ?")
    }
</script>
</html>
