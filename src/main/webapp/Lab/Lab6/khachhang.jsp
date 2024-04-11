<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Khach Hang</title>
</head>
<body class="container">
<h3 class="text-center mb-3 mt-3">Quản lý khach hang</h3>
<form action="/KhachHangServlet/update" method="post">
    Mã: <input type="text" name="makh" class="form-control"/>
    <br/>
    Họ tên: <input type="text" name="hoten" class="form-control"/>
    <br/>
    Dien thoai: <input type="text" name="dienthoai" class="form-control"/>
    <br/>
    Ngay sinh: <input type="date" name="ngaysinh" class="form-control"/>
    <br/>
    Trang thai: <input type="checkbox" name="trangthai" class="form-check-input"/>
    <br/>

    <button class="btn btn-warning" type="submit">Chinh sua</button>
</form>
<h3 class="text-center mb-3 mt-3">Danh sách khach hang</h3>
<table class="table table-hover table-bordered">
    <thead>
    <th>STT</th>
    <th>Mã</th>
    <th>Tên</th>
    <th>SDT</th>
    <th>Ngay sinh</th>
    <th>Trang thai</th>
    <th>Thao tác</th>
    </thead>
    <tbody>
    <c:forEach items="${listKH}" var="kh" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${kh.maKH}</td>
            <td>${kh.hoTen}</td>
            <td>${kh.dienThoai}</td>
            <td>${kh.ngaySinh}</td>
            <td>${kh.trangThai ? "Yes" : "No"}</td>
            <td>
                <button class="btn btn-warning" type="submit">Update</button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
