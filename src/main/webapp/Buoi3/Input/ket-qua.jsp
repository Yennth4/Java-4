<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ket Qua Input</title>
</head>
<body class="container">
    <h1 class="text-center">Thông tin cá nhân của bạn</h1>
    <p>Họ và tên : ${hoten}</p>
    <p>Giới tính : ${gioiTinh ? "Nam" : "Nữ"} </p>
    <p>Password : ${password}</p>
    <p>Mô tả : ${mota}</p>
    <p>Sở thích : ${sothich}</p>
    <p>Quê quán : ${quequan}</p>
    <p>Xác nhận : ${chb1 ? "Đã hiểu" : "Chưa hiểu"}</p>
</body>
</html>
