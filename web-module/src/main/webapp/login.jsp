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
    <title>Formulaire de connexion en HTML & CSS - Frenchcoder</title>

</head>
<body>
<form method="post" action="loginServlet">

    <h1>Se connecter</h1>
    <div class="inputs">
        <input name="email" type="email" placeholder="Email" />
        <input name="password" type="password" placeholder="Mot de passe">
    </div>

    <p class="inscription"> nouveau utilisateur <span><a href="registerServlet">cree</a></span> </p>
    <div align="center">
        <button type="submit">Se connecter</button>
    </div>
</form>
</body>
</html>
