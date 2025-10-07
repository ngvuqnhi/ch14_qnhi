<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả gửi Email</title>
    <link rel="stylesheet" href="result.css">
</head>
<body>
<div class="container">
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <h3 class="error"><%= error %></h3>
    <%
    } else {
        String email = (String) request.getAttribute("email");
        String subject = (String) request.getAttribute("subject");
        String body = (String) request.getAttribute("body");
    %>
    <h2>Đã gửi email đến: <%= email %></h2>
    <h3>Chủ đề: <%= subject %></h3>
    <div class="email-body">
        <%= body %>
    </div>
    <%
        }
    %>
    <a href="index.jsp">← Gửi email khác</a>
</div>
</body>
</html>
