<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>My Simple Homepage</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      text-align: center;
    }
    .container {
      margin: 100px auto;
      max-width: 400px;
    }
    .login-button {
      padding: 10px 20px;
      background-color: #3498db;
      color: #fff;
      border: none;
      border-radius: 5px;
      font-size: 18px;
      cursor: pointer;
    }
    .login-button:hover {
      background-color: #2980b9;
    }
  </style>
</head>
<body>
<div class="container">
  <h1>Welcome to My Website</h1>
  <p>This is a simple homepage.</p>
  <a href="${pageContext.request.contextPath}/auth">
    <button class="login-button">Let's chat!</button>
  </a>
</div>
</body>
</html>
