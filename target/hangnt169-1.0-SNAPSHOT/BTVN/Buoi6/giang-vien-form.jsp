<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="border-style: groove ">
    <form action="/giang-vien/tim-kiem" method="get">
        <br>
        Tên: <input name="ten"/>
        <br><br>
        Tuổi:
        <br><br>
        Min:<input name="min"/>
        <br><br>
        Max:<input name="max"/>
        <br><br>
        <button type="submit">Search</button>
    </form>
</div>
<br>
<form action="" method="post">
    Mã GV: <input type="text" name="maGV" value="${gvfill.maGV}"/> <span class="error">${errorma}</span>
    &emsp;
    Họ tên: <input type="text" name="ten" value="${gvfill.ten}"/> <span class="error">${errorname}</span>
    <br>
    <br>
    Tuổi: <input type="text" name="tuoi" value="${gvfill.tuoi}"/> <span class="error">${errorage}</span>

    Quê quán: <input type="text" name="queQuan" value="${gvfill.queQuan}"/> <span class="error">${erroraddress}</span>
    <br><br> <input type="radio" name="gioiTinh" value="true" ${gvfill.gioiTinh ? 'checked' : ''}/>Nam
    <input type="radio" name="gioiTinh" value="false" ${!gvfill.gioiTinh ? 'checked' : ''}/>Nữ
    <br>
    <button type="submit">Add</button>
</form>
<table border="1">
    <tr>
        <th>Mã GV</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Giới tính</th>
        <th>Quê quán</th>
        <th colspan="2">Action</th>
    </tr>
    <tbody>
    <c:forEach items="${lists}" var="gv" varStatus="indexs">
        <tr>

            <td>${gv.maGV}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${(gv.gioiTinh) ? "Nam":"Nữ"}</td>
            <td>${gv.queQuan}</td>
            <td>
                <button><a href="/giang-vien/detail?detail=${gv.id}">Detail</a></button>
                <button><a href="/giang-vien/view-update?update=${gv.id}">Edit</a></button>
                <button><a href="/giang-vien/remove?deleteMa=${gv.id}">Remove</a></button>

            </td>
        </tr>
    </c:forEach>
    </tbody>
    </tr>
</table>
</body>
</html>
