<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <h2 class="text-center mb-3">LIST CATEGORY</h2>
    <table class="table table-hover table-bordered table-striped text-center">

        <tr class="mb-3">
            <th>ID</th>
            <th>Code</th>
            <th>Name</th>
            <th colspan="2">Action</th>
        </tr>
        <tbody>
        <c:forEach items="${lists}" var="c" varStatus="index">
            <tr>
                <td>${index.index + 1}</td>
                <td>${c.categoryCode}</td>
                <td>${c.categoryName}</td>
                <td>
                    <a href="/category/detail?a=${c.id}">
                        <button class="btn btn-warning">Detail</button>
                    </a>
                    <a href="/category/view-update?b=${c.id}">
                        <button class="btn btn-secondary">Edit</button>
                    </a>
                    <a href="/category/remove?c=${c.id}">
                        <button class="btn btn-outline-danger">Delete</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
