<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
    <title>Update user</title>
</head>
<%--
Validate các trường bắt buộc:  email, fullname
--%>
<body class="container">
<form action="/user/update" method="post">
    <h2 class="text-info text-center mb-3 mt-3">Update user</h2>
    <p>Id : <input type="text" name="id" readonly class="form-control" value="${listUser.id}"></p>
    <p>Email : <input type="email" name="email" class="form-control" value="${listUser.email}"></p>
    <p class="text-danger">${errorMessages["email"]}</p>
    <p>Password <input type="password" name="password" class="form-control" value="${listUser.password}"></p>
    <p>Fullname : <input type="text" name="fullname" class="form-control" value="${listUser.fullname}"></p>
    <p class="text-danger">${errorMessages["fullname"]}</p>
    <p>Admin :
        <input type="checkbox" name="admin" class="form-check-input"
               value="true" ${listUser.admin ? "checked" : ""}>
        <input type="hidden" name="admin" value="false">
    </p>
    <button class="btn btn-success mb-3" type="submit">Add</button>
</form>
</body>
</html>