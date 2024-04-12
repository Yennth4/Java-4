<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quan ly ban</title>
</head>
<body>
<h3 class="mt-3 mb-3">Quan ly ban</h3>
<form action="/ban/update?id=${param.id}" method="post">
    <p>Ma : <input type="text" name="ma" value="${ban.ma}" readonly class="form-control"></p>
    <p class="text-danger">${errorMa}</p>

    <p>Ten : <input type="text" name="ten" value="${ban.ten}" class="form-control"></p>
    <p class="text-danger">${errorTen}</p>

    <p>So thich : <input type="text" name="soThich" value="${ban.soThich}" class="form-control"></p>
    <p class="text-danger">${errorSoThich}</p>

    <p>Gioi tinh :
        <input type="radio" name="gioiTinh" value="1" ${ban.gioiTinh == 1 ? 'checked' : ''}> Nam
        <input type="radio" name="gioiTinh" value="0" ${ban.gioiTinh == 0 ? 'checked' : ''}> Nu
    </p>

    <p>Moi quan he :
        <select name="idmqh" class="form-select">
            <option disabled selected>Chon moi quan he</option>
            <c:forEach items="${listMqh}" var="mqh">
                <option value="${mqh.id}" ${mqh.id == ban.moiQuanHe.id ? 'selected' : ''}>${mqh.ten}</option>
            </c:forEach>
        </select>
    </p>

    <button class="btn btn-warning" type="submit" onclick="if (!confirm('Ban co muon chinh sua ' + ${param.id} + ' khong ?')){return false} else {alert('Sua thanh cong id ' + ${param.id})}">Update</button>
</form>

<table class="table table-hover table-bordered">
    <h3 class="mt-3 mb-3">Danh sach ban</h3>
    <thead>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>So thich</th>
        <th>Gioi tinh</th>
        <th>Moi quan he</th>
        <th>Hanh dong</th>
    </thead>

    <c:forEach items="${listBan}" var="b" varStatus="i">
        <tr onclick="location.href='detail?id=${b.id}'">
            <td>${i.count}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.soThich}</td>
            <td>${b.gioiTinh == 1 ? "Nam" : "Nu"}</td>
            <td>${b.moiQuanHe.ten}</td>
            <td>
                <a href="/BanServlet/detail?id=${b.id}" onclick="return confirm('Ban co muon hien thi khong ?')">
                    <button type="button" class="btn btn-warning">Detail</button>
                </a>
                <a href="/BanServlet/remove?id=${b.id}"
                   onclick="if(!confirm('Ban co muon xoa id ' + ${b.id} + ' khong ?')){return false} else {alert('Xoa thanh cong')}">
                    <button type="button" class="btn btn-outline-danger">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
