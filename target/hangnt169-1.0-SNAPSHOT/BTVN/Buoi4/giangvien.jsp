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
    <h2 class="text-center mb-3">Danh sách giảng viên</h2>
    <table class="table table-hover table-bordered table-striped text-center">
        <form action="" >
            <div class="mb-3">
                Tên: <input name="ten" class="form-control"/>
            </div>
            <button class="btn btn-outline-secondary mb-3" type="submit">Search</button>
        </form>
        <br/>
        <button class="btn btn-info mb-3"><a href="">Add Student</a></button>
<%--        href : link bên servlet--%>
        <tr class="mb-3">
            <th>STT</th>
            <th>ID</th>
            <th>MSSV</th>
            <th>Tên</th>
            <th>Tuổi</th>
            <th>Giới tính</th>
            <th>Địa chỉ</th>
            <th colspan="2">Action</th>
        </tr>
        <tbody>
            <c:forEach var="gv" items="${listGV}" varStatus="i">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${gv.id}</td>
                    <td>${gv.ma}</td>
                    <td>${gv.ten}</td>
                    <td>${gv.tuoi}</td>
                    <td>${gv.gioiTinh ? "Duc" : "Cai"}</td>
                    <td>${gv.diaChi}</td>
                    <td>
                        <button class="btn btn-warning">Detail</button>
                        <button class="btn btn-secondary">Edit</button>
                        <button class="btn btn-outline-danger">Delete</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
