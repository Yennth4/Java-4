<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form input</title>
</head>
<body>
<%--    name là thứ mà servlet có thể nhận ra và lấy gtri--%>
    <form method="post" class="container">
        <p>Họ và tên : <input name="hoten" class="form-control"></p>
        <p>Giới tính :
            <input type="radio" name="gioiTinh" value="true" class="form-check-input"> Nam
            <input type="radio" name="gioiTinh" value="false" class="form-check-input"> Nu</p>
        <p>Password : <input type="password" name="password" class="form-control"></p>
        <p>Mô tả : <textarea name="mota" class="form-control"></textarea></p>
        <p>Sở thích:
            <input type="checkbox" name="sothich" value="bongda"> Bóng đá
            <input type="checkbox" name="sothich" value="docsach"> Đọc sách
            <input type="checkbox" name="sothich" value="anuong"> Ăn uống
        </p>
        <p> Quê quán :
            <select class="form-select" name="quequan">
                <option selected>Chọn</option>
                <option value="">VP</option>
                <option value="">HN</option>
                <option value="">HCM</option>
            </select>
        </p>
<%--        check box chọn nhiều , nếu k để gtri value thì  --%>
        <p><input type="checkbox" name="chb1" class="form-check-input" value=""> Đã đọc và hiểu nội quy</p>
        <button class="btn btn-success">Đăng ký</button>
    </form>
</body>
</html>
