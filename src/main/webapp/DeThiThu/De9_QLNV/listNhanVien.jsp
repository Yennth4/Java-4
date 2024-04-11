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
<form action="/nhan-vien/update" method="post">
    <p>ID : <input type="text" name="id" value="${nv.id}" readonly></p>
    <p>Ma : <input type="text" name="ma" value="${nv.ma}"></p> ${erMa}

    <p>Ten : <input type="text" name="ten" value="${nv.ten}"></p> ${erTen}

    <p>Mat khau : <input type="password" name="matKhau" value="${nv.matKhau}"></p> ${erMatKhau}

    <p>Trang thai :
        <input type="radio" name="trangThai" value="1" ${nv.trangThai == 1 ? 'checked' : ''}> Di lam
        <input type="radio" name="trangThai" value="0" ${nv.trangThai == 0 ? 'checked' : ''}> Nghi lam
    </p>
    <p>Chuc vu:
        <select name="IdCV">
            <option selected disabled>------</option>
            <c:forEach items="${listChucVu}" var="cv">
                <option value="${cv.id}" ${cv.id == nv.chucVu.id ? 'selected' : ''}>${cv.ten}</option>
            </c:forEach>
        </select>
    </p>
    <button type="submit" onclick="return confirm('Ban co muon them ?')">Add</button>
    <button type="submit" onclick="if (!confirm('Ban co muon chinh sua ' + ${param.id} + ' khong ?')){return false} else {alert('Sua thanh cong id ' + ${param.id})}">Update</button>
</form>
<table>
    <thead>
        <th>STT</th>
        <th>Ma</th>
        <th>Ten</th>
        <th>Mat khau</th>
        <th>Trang thai</th>
        <th>ID chuc vu</th>
        <th>Ten chuc vu</th>
        <th>Action</th>
    </thead>
    <c:forEach items="${listNhanVien}" var="b" varStatus="i">
        <tr onclick="location.href='detail?id=${b.id}'">
            <td>${i.count}</td>
            <td>${b.ma}</td>
            <td>${b.ten}</td>
            <td>${b.matKhau}</td>
            <td>${b.trangThai == 1 ? "Di lam" : "Nghi lam"}</td>
            <td>${b.chucVu.id}</td>
            <td>${b.chucVu.ten}</td>
            <td>
                <a href="/nhan-vien/detail?id=${b.id}">
                    <button type="button" onclick="return confirm('Ban co muon fill du lieu len bang khong ?')">Detail</button>
                </a>
                <a href="/nhan-vien/remove?id=${b.id}">

                    <button type="button" onclick="if (!confirm('Ban co muon xoa id ' + ${b.id} + ' khong ?')){return false} else {alert('Xoa thanh cong id ' + ${b.id})}">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
