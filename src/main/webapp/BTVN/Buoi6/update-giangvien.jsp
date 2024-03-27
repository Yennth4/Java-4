<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/26/2024
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/update" method="post">

    ID: <input type="text" name="id" readonly="False" value="${gvfill.id}"/>
    Mã GV: <input type="text" name="maGV" value="${gvfill.maGV}"/>
    &emsp;
    Họ tên: <input type="text" name="ten" value="${gvfill.ten}"/>
    <br>
    <br>
    Tuổi: <input type="text" name="tuoi" value="${gvfill.tuoi}"/>

    Quê quán: <input type="text" name="queQuan" value="${gvfill.queQuan}"/>
    <br><br> <input type="radio" name="gioiTinh" value="true" ${gvfill.gioiTinh ? 'checked' : ''}/>Nam
    <input type="radio" name="gioiTinh" value="false" ${!gvfill.gioiTinh ? 'checked' : ''}/>Nữ
    <br>
    <button type="submit">update</button>
</form>
</body>
</html>
