<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>QLDT</title>
</head>
<body>
    <h2 class="text-center mb-3  mt-3">Quan ly dien thoai</h2>
    <form action="/B6L2-ket-qua" method="post" class="container">
        Ten: <input type="text" name="ten" class="form-control"/>
        <br/>
        Don gia: <input type="number" name="gia" class="form-control"/>
        <br/>
        Hang :
        <input type="radio" name="hang" checked value="Apple" class="form-check-input"/> Apple
<%--        <input type="radio" name="hang" value="Samsung" class="form-check-input"/> Samsung--%>
        <input type="radio" name="hang" value="Nokia" class="form-check-input"/> Nokia
        <br/>

        <p> Mau sac :
            <select class="form-select" name="mausac">
                <option value="Xanh" >Xanh</option>
                <option value="Do" >Do</option>
                <option value="Tim" >Tim</option>
                <option value="Vang">Vang</option>
            </select>
        </p>

        <p> Con hang : <input type="checkbox" name="conhang" value="conhang"> Checkbox </p>
        Mo ta :
        <textarea name="mota" placeholder="san pham moi ve"  class="form-control"></textarea>
        <br>

        <div class="text-center">
            <p class="text-danger">${msg}</p>
            <p class="text-danger">${giaDuong}</p>
            <button class="btn btn-success text-center mt-3" type="submit">Luu lai</button>
        </div>
    </form>

</body>
</html>
