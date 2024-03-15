<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- su dung JSTL : tren GIT --%>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <div class="img-container" >
            <img width="120px" src="https://iptime.com.vn/wp-content/uploads/2018/12/logo-fpt.jpg">
        </div>
        <form class="d-flex" role="search">
            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success" type="submit">Search</button>
        </form>
    </div>
</nav>

<div class="container">
    <h2 class="text-center mb-3">Danh sách sinh viên</h2>
    <table class="table table-hover table-bordered table-striped text-center">
        <form action="" >
            <div class="mb-3">
                Tên: <input name="ten" class="form-control"/>
            </div>
            <button class="btn btn-outline-secondary mb-3" type="submit">Search</button>
        </form>
        <br/>
        <button class="btn btn-info mb-3"><a href="/sinh-vien/view-add">Add Student</a></button>
<%--        href : link bên servlet--%>
        <tr class="mb-3">
            <th>STT</th>
            <th>MSSV</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Địa chỉ</th>
            <th>Giới tính</th>
            <th colspan="2">Action</th>
        </tr>
        <tbody>
            <c:forEach items="${listSV}" var="sv" varStatus="index">
        <%--    listSV : la gtri truyen tu servlet--%>
                <tr>
                    <td>${index.index + 1}</td>
                    <td>${sv.mssv}</td>
                    <td>${sv.ten}</td>
                    <td>${sv.tuoi}</td>
                    <td>${sv.diaChi}</td>
                    <td>${sv.gioiTinh ? "Nam" : "Nu"}</td>
                    <td>
                        <button class="btn btn-warning"><a href="/sinh-vien/detail?a=${sv.mssv}">Detail</a></button>
                        <button class="btn btn-secondary"><a href="/sinh-vien/view-update?b=${sv.mssv}">Edit</a></button>
                        <button class="btn btn-outline-danger"><a href="/sinh-vien/remove?c=${sv.mssv}">Delete</a></button>
<%--                        xoa theo ma  --%>
<%--            Xoa theo vi tri
                        <button class="btn btn-outline-danger"><a href="/sinh-vien/remove?c=${index.index}">Delete</a></button>
--%>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
