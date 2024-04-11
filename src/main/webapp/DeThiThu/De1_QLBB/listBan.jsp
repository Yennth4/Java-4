<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quan ly ban</title>
</head>
<body class="container">
<form action="/BanServlet/add" method="post">
    <p>Ma : <input type="text" name="ma" class="form-control" value="${fillListBan.ma}"></p>
    <span class="text-danger">${errorMa}</span>

    <p>Ten : <input type="text" name="ten" class="form-control" value="${fillListBan.ten}"></p>
    <span class="text-danger">${errorTen}</span>

    <p>So thich : <input type="text" name="soThich" class="form-control" value="${fillListBan.soThich}"></p>
    <span class="text-danger">${errorSoThich}</span>

    <p>Gioi tinh :
        <input type="radio" name="gioiTinh" value="1" checked ${fillListBan.gioiTinh == 1 ? 'checked' : ''} > Nam
        <input type="radio" name="gioiTinh" value="0" ${fillListBan.gioiTinh == 0 ? 'checked' : ''} > Nu
    </p>
    <p>Moi quan he :
        <select name="idmqh" class="form-select">
            <option value="" disabled>Chon moi quan he</option>
            <c:forEach items="${listMQH}" var="mqh" >
                <option value="${mqh.id}">${mqh.ten}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit" onclick="return confirm('Ban co muon them khong ?')" class="btn btn-success">Add</button>
    <button type="submit" onclick="return confirm('Ban co muon sua khong ?')" class="btn btn-warning">Chinh sua</button>
</form>
<table class="table table-hover table-bordered">
    <thead>
    <th>STT</th>
    <th>Ma</th>
    <th>Ten</th>
    <th>So thich</th>
    <th>Gioi tinh</th>
    <th>ID mqh</th>
    <th>Ten mqh</th>
    <th>Hanh dong</th>
    </thead>

    <c:forEach items="${listBan}" var="b" varStatus="i">
        <tr onclick="location.href='detail?id=${b.id}'">
            <td>${i.count}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.soThich}</td>
            <td>${b.gioiTinh == 1 ? "Nam" : "Nu"}</td>
            <td>${b.moiQuanHe.id}</td>
            <td>${b.moiQuanHe.ten}</td>
            <td>
                <a href="/BanServlet/detail?id=${b.id}" onclick="return confirm('Ban co muon hien thi khong ?')">
                    <button type="button" class="btn btn-warning">Detail</button>
                </a>
                <a href="/BanServlet/remove?id=${b.id}"
                   onclick="return confirm('Ban co muon xoa id ' + ${b.id} + ' khong ?')">
                    <button type="button" class="btn btn-outline-danger">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
