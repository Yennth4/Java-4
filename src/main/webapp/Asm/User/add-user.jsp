<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Add user</title>
</head>
<%--
Yêu cầu:
Validate các trường bắt buộc: id, password, email, fullname
Validate password: độ dài lớn hơn hoặc bằng 6, chứa ít nhất 1 chữ số và ít nhất 1 chữ cái

--%>
<body class="container">
<form action="/user/add" method="post">
    <h2 class="text-info text-center mb-3 mt-3">Add user</h2>
    <p>Id : <input type="text" name="id" class="form-control"></p>
    <p class="text-danger">${errorMessages["id"]}</p>
    <p>Email : <input type="email" name="email" class="form-control"></p>
    <p class="text-danger">${errorMessages["email"]}</p>
    <p>Password <input type="password" name="password" class="form-control"></p>
    <p class="text-danger">${errorMessages["password"]}</p>
    <p>Fullname : <input type="text" name="fullname" class="form-control"></p>
    <p class="text-danger">${errorMessages["fullname"]}</p>
    <p>Admin : <input type="checkbox" name="admin" value="true" class="form-check-input"></p>
    <button class="btn btn-success mb-3" type="submit">Add</button>
</form>
</body>
</html>