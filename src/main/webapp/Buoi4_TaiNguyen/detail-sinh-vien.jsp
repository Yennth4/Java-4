<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="text-center mb-3  mt-3">Thong tin sinh vien</h2>
<form action="/sinh-vien/add" method="post" class="container">
    MSSV: <input type="text" name="mssv" class="form-control" value="${listSV.mssv}" disabled/>
    <br/>
    Tên: <input type="text" name="ten" class="form-control" value="${listSV.ten}"/>
    <br/>
    Tuổi: <input type="text" name="tuoi" class="form-control" value="${listSV.tuoi}"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true" ${listSV.gioiTinh ? "checked" : ""} class="form-check-input"/> Nam
    <input type="radio" name="gioiTinh" value="false" ${!listSV.gioiTinh ? "checked" : ""} class="form-check-input"/> Nữ
    <br/><br/>
    Địa chỉ: <input type="text" name="diaChi" class="form-control" value="${listSV.diaChi}"/>
    <br/>
</form>
</body>
</html>
