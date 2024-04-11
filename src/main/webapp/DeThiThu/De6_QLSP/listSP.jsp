<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Quan ly nhan vien</title>
</head>
<body>
<h2>Quan ly nhan vien</h2>
<form action="/san-pham/update2" method="post">
    <p>ID : <input type="text" name="id" value="${sp.id}" readonly></p>
    <p>Ma : <input type="text" name="ma" value="${sp.ma}"></p>
    <p>Ten : <input type="text" name="ten" value="${sp.ten}"></p>
    <p>Gia ban : <input type="number" name="giaBan" value="${sp.giaBan}"></p>
    <p>So luong : <input type="number" name="soLuong" value="${sp.soLuong}"></p>
    <p>Loai sp :
        <select name="IdLoaiSP">
            <c:forEach items="${listLoaiSP}" var="loaiSP">
                <option value="${loaiSP.id}" ${loaiSP.id == sp.loaiSanPham.id ? 'selected' : ''}>${loaiSP.ten}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit">Add</button>
</form>
<table>
    <thead>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Gia ban</th>
        <th>So luong</th>
        <th>Loai SP</th>
        <th>Action</th>
    </thead>
    <c:forEach items="${listSP}" var="b" varStatus="i">
        <tr onclick="location.href='detail2?id=${b.id}'">
            <td>${i.count}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.giaBan}</td>
            <td>${b.soLuong}</td>
            <td>${b.loaiSanPham.ten}</td>
            <td>
                <a href="/san-pham/detail2?id=${b.id}" onclick="return confirm('Ban co muon hien thi ?')">
                    <button>Detail</button>
                </a>
                <a href="/san-pham/remove2?id=${b.id}" onclick="return confirm('Ban co muon xoa ?')">
                    <button>Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
