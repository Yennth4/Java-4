<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
            <div class="img-container" >
                <img width="120px" src="https://iptime.com.vn/wp-content/uploads/2018/12/logo-fpt.jpg">
            </div>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </nav>
    <div class="container">
        <h2 class="text-info mb-3 mt-3 text-center">Danh sach san pham</h2>

        <div>
            <p>Ten : <input class="form-control" name="searchName"></p>
            <button class="btn btn-info mb-3">Search</button>
        </div>

        <div>
            <p>ID : <input class="form-control" name="id"></p>
            <p>Ma : <input class="form-control" name="ma"></p>
            <p>Ten : <input class="form-control" name="ten"></p>
            <p>Gia : <input class="form-control" name="gia"></p>
            <p>Loai :
                <select name="loai" class="form-select">
                    <option>Loai 1</option>
                    <option>Loai 2</option>
                    <option>Loai 3</option>
                    <option>Loai 4</option>
                </select>
            </p>
            <p>
                <button class="btn btn-success">Add</button>
            </p>
        </div> <hr>

        <div>
            <table class="table table-bordered table-hover table-striped">
                <form>
                    <thead class="text-center">
                        <th>ID</th>
                        <th>Ma</th>
                        <th>Ten</th>
                        <th>Loai</th>
                        <th>Gia</th>
                        <th>Action</th>
                    </thead>
                    <tbody>
                    <%--            hien thi --%>
                    <c:forEach  items="${listSP}" var="sp">
                        <tr>
                            <td class="text-center">${sp.id}</td>
                            <td>${sp.ma}</td>
                            <td>${sp.ten}</td>
                            <td>${sp.loai}</td>
                            <td>${sp.gia}</td>
                            <td class="text-center">
                                <a href="/san-pham/detail?a=${sp.id}"><button class="btn btn-secondary">Detail</button></a>
                                <a href="/san-pham/update?b=${sp.id}"><button class="btn btn-warning">Edit</button></a>
                                <a href="/san-pham/remove?c=${sp.id}"><button class="btn btn-outline-danger">Delete</button></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </form>
            </table>
        </div>

    </div>
</body>
</html>
