<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<html>
<head>
    <title>Detail movie</title>
</head>
<body class="container">
    <h2  class="text-info text-center mb-3 mt-3">Detail movie</h2>
    <p>Id : <input type="text" name="id" readonly class="form-control" value="${listMovie.id}"></p>
    <p>Title <input type="text" name="title" disabled class="form-control" value="${listMovie.title}"></p>
    <p>Description : <textarea name="description" disabled class="form-control">${listMovie.description}</textarea></p>
    <p>Active : <input type="checkbox" name="active" disabled class="form-check-input" value="${listMovie.active ? 'true' : 'false'}" ${listMovie.active ? 'checked' : ''}></p>
    <p>Poster : <input type="image" name="poster" disabled class="form-control" value="${listMovie.poster}"></p>
    <a href="/movie/hien-thi"><button type="submit">Back</button></a>
</body>
</html>