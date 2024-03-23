<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Add movie</title>
</head>
<body class="container">
<form method="post" action="/movie/add">
    <h2 class="text-info text-center mb-3 mt-3">Add movie</h2>
    <p>Id : <input type="text" name="id" class="form-control"></p>
    <p class="text-danger">${errorMessages["id"]}</p>
    <p>Title : <input type="text" name="title" class="form-control"></p>
    <p class="text-danger">${errorMessages["title"]}</p>
    <p>Description : <textarea name="description" class="form-control"></textarea></p>
    <p>Active : <input type="checkbox" name="active" value="true" class="form-check-input"></p>
    <p>Poster : <input type="url" name="poster" class="form-control"></p>
    <p class="text-danger">${errorMessages["poster"]}</p>
    <button class="btn btn-success mb-3" type="submit">Save</button>
</form>
</body>
</html>
