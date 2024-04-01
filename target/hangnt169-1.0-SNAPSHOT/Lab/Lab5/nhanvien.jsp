<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhan Vien</title>
</head>
<body class="container">
<h3 class="text-center mb-3 mt-3">Quản lý nhân viên</h3>
<form action="/NhanVienServlet/add" method="post">
    Mã: <input type="text" name="ma" class="form-control"/>
    <br/>
    Họ tên: <input type="text" name="ten" class="form-control"/>
    <br/>
    Giới tính :
    <input type="radio" name="gioiTinh" checked value="Nam" class="form-check-input"/> Nam
    <input type="radio" name="gioiTinh" value="Nữ" class="form-check-input"/> Nữ

    <p class="mt-3">Phòng ban :
        <select class="form-select" name="phongBan">
            <option value="CSKH">CSKH</option>
            <option value="Kế toán">Kế toán</option>
            <option value="IT">IT</option>
        </select>
    </p>

    Lương: <input type="number" name="luong" class="form-control"/>
    <br/>

    <button class="btn btn-success" type="submit">Thêm</button>
</form>
<h3 class="text-center mb-3 mt-3">Danh sách nhân viên</h3>
<table class="table table-hover table-bordered">
    <thead>
        <th>STT</th>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giới tính</th>
        <th>Phòng ban</th>
        <th>Lương</th>
        <th>Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${listNV}" var="nv" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.gioiTinh ? "Nam" : "Nữ"}</td>
            <td>${nv.phongBan}</td>
            <td>${nv.luong}</td>
            <td>
                <a href="/NhanVienServlet/detail?c=${nv.ma}"><button class="btn btn-secondary" type="submit">Detail</button></a>
                <a href="/NhanVienServlet/update?c=${nv.ma}"><button class="btn btn-warning" type="submit">Update</button></a>
                <a href="/NhanVienServlet/remove?c=${nv.ma}" onclick="return confirmDelete();">
                    <button class="btn btn-outline-danger" type="submit">Remove</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<script>
    function confirmDelete() {
        return confirm("Ban chac chan muon xoa chu ?");
    }
</script>
</html>

