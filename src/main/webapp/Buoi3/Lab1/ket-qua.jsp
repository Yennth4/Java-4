<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hóa đơn</title>
</head>
<body>
<h3 class="text-center">Hóa đơn của bạn </h3>
<table class="table table-dark table-striped table-hover table-bordered text-center">
    <thead>
        <tr>
            <th>STT</th>
            <th scope="col">Đơn giá</th>
            <th scope="col">Số lượng</th>
            <th scope="col">Giảm giá</th>
            <th scope="col">Giá trị</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <th scope="row">1</th>
            <td>${donGia}</td>
            <td>${soLuong}</td>
            <td>${giamGia}</td>
            <td>${tinhGiaTri}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
