<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>
<h3 class="text-center mb-3 mt-3">Sửa điện thoại</h3>
<form action="/phone/update" method="post">
ID: <input type="text" name="id" class="form-control" value="${listPhone.id}"/>
<br/>
Tên: <input type="text" name="ten" class="form-control" value="${listPhone.ten}"/>
<br/>
Giá: <input type="text" name="gia" class="form-control" value="${listPhone.gia}"/>
<br/>
Hãng :
<input type="radio" name="hang" checked value="Apple" class="form-check-input"/> Apple
<input type="radio" name="hang" value="Samsung" class="form-check-input"/> Samsung
<input type="radio" name="hang" value="Nokia" class="form-check-input"/> Nokia

<p class="mt-3">Màu sắc :
    <select class="form-select" name="mausac" value="${listPhone.mauSac}">
        <option>Chọn</option>
        <option value="Xanh">Xanh</option>
        <option value="Do">Do</option>
        <option value="Tim">Tim</option>
        <option value="Vang">Vang</option>
    </select>
</p>
    <button class="btn btn-warning" type="submit">Save</button>
</form>
</body>
</html>
