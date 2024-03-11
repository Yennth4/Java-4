<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form thanh toán</title>
</head>
<body>
<h3 class="text-center">Form thanh toán</h3>
<form class="container" method="post">
    <p>
      Đơn giá : <input type="text" name="donGia" class="form-control">
    </p>

    <p>
      Số lượng : <input type="text" name="soLuong" class="form-control">
    </p>

    <p>
      Giảm giá : <input type="text" name="giamGia" class="form-control">
    </p>
  <button type="submit" class="btn btn-success">Tính giá trị</button>
</form>
</body>
</html>
