<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Sua movie</title>
</head>
<%--
Validate các trường dữ liệu bắt buộc: title, poster, thiếu trường nào báo lỗi bên cạnh trường đó
--%>
<body class="container">
<form method="post" action="/movie/update">
    <h2 class="text-info text-center mb-3 mt-3">Update movie</h2>
    <p>Id : <input type="text" name="id" readonly class="form-control" value="${form.id}"></p>
    <p class="text-danger">${errorMessages["id"]}</p>
    <p>Title <input type="text" name="title" class="form-control" value="${form.title}"></p>
    <p class="text-danger">${errorMessages["title"]}</p>
    <p>Description : <textarea name="description"  class="form-control">${form.description}</textarea></p>
    <p>Active :
        <input type="checkbox" name="active" class="form-check-input" value="true" ${form.active == true ? 'checked' : ''}>
<%--        <input type="hidden" name="active" value="false">--%>
    </p>
    <p>Poster : <input type="text" name="poster" class="form-control" value="${form.poster}"></p>
    <p class="text-danger">${errorMessages["poster"]}</p>
    <button class="btn btn-success mb-3" type="submit">Save</button>
</form>
</body>
</html>
