<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 29/01/2024
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Formulaire d'inscription</title>
    <style>

    </style>
</head>
<body>
<form method="post" action="registerServlet">
    <h1>S'incrire</h1>
    <div class="inputs">
        <input type="email" name="email" placeholder="Email" />
        <input type="password" name="password" placeholder="Mot de passe">
        <input type="password" name="confirmPassword" placeholder="confirmer le Mot de passe">
    </div>
    <p class="inscription">Je ai un<span>compte</span>. Je me <span><a href="login.jsp">connecte</a></span> un.</p>
    <div align="center">
        <button type="submit">S'incrire</button>
    </div>
</form>
</body>
</html>
