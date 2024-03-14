<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 3/14/2024
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body >
<form method="post">
    <p>Cạnh a: <input name="a" value="${param.a}"></p>
    <p>Cạnh b: <input name="b" value="${param.b}"></p>
    <p>Cạnh c: <input name="c" value="${param.c}"></p>
    <button formaction="chu-vi" >Chu vi</button>
    <button formaction="dien-tich" >Diện tích</button>
    <p>${tbLoi}</p>
    <p>Chu vi : ${chuvi}</p>
    <p>Dien tich : ${dientich}</p>
</form>
</body>
</html>
