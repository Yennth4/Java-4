<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/15/2024
  Time: 9:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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
    Mã GV: <input type="text" name="maGV" value="${gv1.maGV}"/> <span class="error">${errorma}</span>
    &emsp;
    Họ tên: <input type="text" name="ten" value="${gv1.ten}"/> <span class="error">${errorname}</span>
    <br>
    <br>
    Tuổi: <input type="text" name="tuoi" value="${gv1.tuoi}"/> <span class="error">${errorage}</span>

    Quê quán: <input type="text" name="queQuan" value="${gv1.queQuan}"/> <span class="error">${erroraddress}</span>
    <br><br>
    <button type="submit">Add</button>
</form>
<table border="1">
    <tr>
        <th>Mã GV</th>
        <th>Họ tên</th>
        <th>Tuổi</th>
        <th>Quê quán</th>
        <th colspan="2">Action</th>
    </tr>
    <tbody>
    <c:forEach items="${lists}" var="gv">
        <tr>
            <td>${gv.maGV}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.queQuan}</td>
            <td>
                <button><a href="/giang-vien/detail?detail=${gv.maGV}">Detail</a> </button>
                <button><a href="/giang-vien/remove?deleteMa=${gv.maGV}">Remove</a> </button>
                <button><a href="/giang-vien/view-update?update=${gv.maGV}">Edit</a> </button>
            </td>
        </tr>
    </c:forEach>

    </tbody>

    </tr>
</table>


</body>
</html>
