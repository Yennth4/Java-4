<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Detail user</title>
</head>
<body class="container">
    <h2 class="text-info text-center mb-3 mt-3">Detail user</h2>
    <p>Id : <input type="text" name="id" readonly class="form-control" value="${listUser.id}"></p>
    <p>Email : <input type="email" name="email" disabled class="form-control" value="${listUser.email}"></p>
    <p>Password <input type="password" name="password" disabled class="form-control" value="${listUser.password}"></p>
    <p>Fullname : <input type="text" name="fullname" disabled class="form-control" value="${listUser.fullname}"></p>
    <p>Admin : <input type="checkbox" name="admin" disabled class="form-check-input" value="${listUser.admin ? "true" : "false"}" ${listUser.admin ? "checked" : ""}></p>
    <a href="/user/hien-thi"><button type="submit">Back</button></a>
</body>
</html>