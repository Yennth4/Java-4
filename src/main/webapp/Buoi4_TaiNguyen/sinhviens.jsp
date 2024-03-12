<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- su dung JSTL : tren GIT --%>
<table class="table table-hover table-bordered table-dark table-striped text-center">
    <form action="">
        <div class="mb-3">
            Tên: <input name="ten" class="form-control"/>
            <button class="btn btn-outline-info" type="submit">Search</button>
        </div>
    </form>
    <br/>
    <button class="btn btn-success mb-3"><a href="">Add Student</a></button>
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
        <tr ng-repeat="item in listSinhVien">
            <td>${index + 1}</td>
            <td>${item.mssv}</td>
            <td>${item.ten}</td>
            <td>${item.tuoi}</td>
            <td>${item.diaChi}</td>
            <td>${item.gioiTinh}</td>
        </tr>
    </tbody>
</table>
</body>
</html>
