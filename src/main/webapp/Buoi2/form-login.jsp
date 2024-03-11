<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>

    <div class="img-container" >
        <img width="100px" src="https://iptime.com.vn/wp-content/uploads/2018/12/logo-fpt.jpg">
    </div>

    <form action="/ket-qua" method="post">

<%--  name của các ô input để serlet có thể lấy dữ liệu    --%>
        <div class="container">
            <h1 class="mb-3 text-center" style="font-family: 'Times New Roman';">
                ${messageJSP}
            </h1>
            <div class="mb-3">
                <label for="uname" class="form-label"><b>Username : </b></label>
                <input type="text" placeholder="Enter Username" name="uname" class="form-control">
                <p class="text-danger">${validateUSName}</p>
            </div>

            <div class="mb-3">
                <label for="psw" class="form-label"><b>Password : </b></label>
                <input type="password" placeholder="Enter Password" name="psw" class="form-control">
                <p class="text-danger">${validatePassword}</p>
            </div>

            <div class="mb-3 text-center">
                <p class="text-danger">${checkUsPw}</p>
                <button type="submit" class="btn btn-success">Login</button>
            </div>
        </div>
    </form>
</body>
</html>
