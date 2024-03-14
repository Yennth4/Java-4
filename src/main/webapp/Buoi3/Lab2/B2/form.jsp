<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form dang ky Lab 2</title>
</head>
<body>
    <form action="B2L2-ket-qua" method="post" class="container">
        <h2 class="text-center text-danger">Dang ky</h2>
        <p>Ten dang nhap : <input name="usname" type="text" class="form-control" required></p>
        <p>Mat khau : <input name="pwd" type="password" class="form-control" required></p>
        <p>Gioi tinh : <input name="gioitinh" type="radio" value="true" class="form-check-input" checked> Nam
            <input name="gioitinh" type="radio" value="false" class="form-check-input"> Nu</p>
        <p><input name="xacNhan" type="checkbox" class="form-check-input"> Da co gia dinh ? </p>
        <p>
            So thich : <input name="sothich" type="checkbox" value="Da bong" class="form-check-input"> Da bong
            <input name="sothich" type="checkbox" value="Cau long" class="form-check-input"> Cau long
            <input name="sothich" type="checkbox" value="Bong chuyen" class="form-check-input"> Bong chuyen
        </p>
        <p>
            Quoc gia :
            <select name="quocgia" class="form-selected">
                <option selected>Choose</option>
                <option>VN</option>
                <option>US</option>
                <option>EK</option>
            </select>
        </p>
        <p>Ghi chu : <textarea name="note" placeholder="Dang tim nguoi yeu" required class="form-control"></textarea></p>
        <hr>
        <button type="submit" class="btn btn-success text-control">Dang ky</button>
    </form>
</body>
</html>
