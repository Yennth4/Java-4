<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/san-pham/add1" method="post">
    <p>Ten : <input type="text" name="ten"></p>
    <p>Dong san pham :
        <select name="idDongSP">
            <option value="65ed8d2d-1623-446c-bf34-2c99fa6774f0">IPhone</option>
            <option value="65ed8d2d-1623-446c-bf34-2c99fa6774f1">Android</option>
        </select>
    </p>
    <p>So luong ton : <input type="number" name="soLuongTon"></p>
    <p>Gia nhap : <input type="number" name="giaNhap"></p>
    <p>Gia ban : <input type="number" name="giaBan"></p>
    <p>Mo ta : <input type="text" name="moTa"></p>
    <p><button type="submit">Save</button></p>
</form>

<c:forEach items="${listSanPham}" var="sp" varStatus="i">
    <thead>
        <th>STT</th>
        <th>ID</th>
        <th>ID Dong SP</th>
        <th>Ten</th>
        <th>So Luong Ton</th>
        <th>Gia Nhap</th>
        <th>Gia Ban</th>
        <th>Mo Ta</th>
    </thead>
    <tr>
        <td>${i.index + 1}</td>
        <td>${sp.id}</td>
        <td>${sp.idDongSP}</td>
        <td>${sp.ten}</td>
        <td>${sp.soLuongTon}</td>
        <td>${sp.giaNhap}</td>
        <td>${sp.giaBan}</td>
        <td>${sp.moTa}</td>
    </tr>
</c:forEach>
</body>
</html>
