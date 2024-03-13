<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2 class="text-center mb-3  mt-3">Them sinh vien</h2>
<form action="/sinh-vien/add" method="post" class="container">
    MSSV: <input type="text" name="mssv" class="form-control"/>
    <br/>
    Tên: <input type="text" name="ten" class="form-control"/>
    <br/>
    Tuổi: <input type="text" name="tuoi" class="form-control"/>
    <br/>
    Địa chỉ: <input type="text" name="diaChi" class="form-control"/>
    <br/>
    Giới tính:
    <input type="radio" name="gioiTinh" checked value="true" class="form-check-input"/> Nam
    <input type="radio" name="gioiTinh" value="false" class="form-check-input"/> Nữ
    <br/>
    <button class="btn btn-success text-center mt-3" type="submit">Add</button>
</form>
</body>
</html>
