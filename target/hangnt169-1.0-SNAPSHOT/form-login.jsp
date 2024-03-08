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
        <h1 style="font-family: 'Times New Roman'; margin-left: 50px">
            ${messageJSP}
        </h1>

<%--  name của các ô input để serlet có thể lấy dữ liệu    --%>
        <div class="container text-center">
            <div>
                <label for="uname"><b>Username : </b></label>
                <input type="text" placeholder="Enter Username" name="uname"  required>
            </div>

            <div style="margin-top: 10px">
                <label for="psw"><b>Password : </b></label>
                <input type="password" placeholder="Enter Password" name="psw"  required> <br>
            </div>

            <div style="margin-top: 10px; margin-left: 200px">
                ${m}
                <button type="submit">Login</button>
            </div> <br>
        </div>
    </form>
</body>
</html>
