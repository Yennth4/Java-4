<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 3/16/2024
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/giang-vien/update" method="post">
    Mã GV: <input type="text" name="maGV"  value="${gv.maGV}"/>
    <span class="error">${errorma}</span>
    <br/>
    Tên: <input type="text" name="ten" value="${gv.ten}"/><span class="error">${errorname}</span>
    <br/>
    Tuổi: <input type="text" name="tuoi" value="${gv.tuoi}"/><span class="error">${errorage}</span>
    <br/>
    Quê Quán: <input type="text" name="queQuan" value="${gv.queQuan}"/> <span class="error">${erroraddress}</span>
    <br/>

    <button type="submit">Update</button>
</form>

</body>
</html>
