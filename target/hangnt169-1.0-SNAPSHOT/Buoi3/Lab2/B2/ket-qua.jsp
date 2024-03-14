<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thong tin dang ky</title>
</head>
<body>
    <h2 class="text-center text-danger">Thong tin dang ky</h2>
    <p>Ten dang nhap : ${usname}</p>
    <p>Mat khau : ${pwd}</p>
    <p>Gioi tinh: ${ gioitinh ? "Nam" : "Nu"}</p>
    <p>Tinh trang : ${xacNhan ? "Da co gia dinh" : ""}</p>
    <p>So thich : ${sothich}</p>
    <p>Quoc gia : ${quocgia}</p>
    <p>Ghi chu : ${note}</p>
</body>
</html>
