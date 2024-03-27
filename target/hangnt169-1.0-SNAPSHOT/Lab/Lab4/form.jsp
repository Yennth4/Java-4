<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Phone</title>
</head>
<body class="container">
<h3 class="text-center mb-3 mt-3">Thêm điện thoại</h3>
<form action="/phone/add" method="post">
    ID: <input type="text" name="id" class="form-control"/>
    <br/>
    Tên: <input type="text" name="ten" class="form-control"/>
    <br/>
    Giá: <input type="number" name="gia" class="form-control"/>
    <br/>
    Hãng :
    <input type="radio" name="hang" checked value="Apple" class="form-check-input"/> Apple
    <input type="radio" name="hang" value="Samsung" class="form-check-input"/> Samsung
    <input type="radio" name="hang" value="Nokia" class="form-check-input"/> Nokia

    <p class="mt-3">Màu sắc :
        <select class="form-select" name="mausac">
            <option>Chọn</option>
            <option value="Xanh">Xanh</option>
            <option value="Do">Do</option>
            <option value="Tim">Tim</option>
            <option value="Vang">Vang</option>
        </select>
    </p>
    <button class="btn btn-success" type="submit">Add</button>
</form>
<h3 class="text-center mb-3 mt-3">Danh sách điện thoại</h3>
<table class="table table-hover table-bordered">
    <thead>
        <th>Id</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Hãng</th>
        <th>Màu sắc</th>
        <th>Action</th>
    </thead>
    <tbody>
    <c:forEach items="${listPhone}" var="phone" varStatus="index">
        <tr>
            <td>${index.index + 1}</td>
            <td>${phone.ten}</td>
            <td>${phone.gia}</td>
            <td>${phone.hang}</td>
            <td>${phone.mauSac}</td>

            <td>
                <a href="/phone/detail?a=${phone.id}">
                    <button class="btn btn-secondary">Detail</button>
                </a>
                <a href="/phone/update?b=${phone.id}">
                    <button class="btn btn-warning">Update</button>
                </a>
                <a href="/phone/remove?c=${phone.id}" onclick="return confirmDelete();">
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
        return confirm("Bạn chắc chắn muốn xóa chứ ?")
    }
</script>
</html>
