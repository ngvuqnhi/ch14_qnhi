<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gửi Email với JavaMail</title>
    <link rel="stylesheet" href="main.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="card">
        <h1>Gửi Email</h1>
        <p>Vui lòng nhập địa chỉ email của bạn</p>
        <form action="sendEmail" method="post" class="email-form">
            <label for="email">Địa chỉ email:</label>
            <input type="email" id="email" name="email" placeholder="Nhập email của bạn..." required>
            <button type="submit">Gửi Email</button>
        </form>
        <p class="footer">23133050 - Nguyễn Vũ Quỳnh Nhi - Chương 14</p>
    </div>
</div>
</body>
</html>
