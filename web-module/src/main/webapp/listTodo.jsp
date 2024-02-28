<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 29/01/2024
  Time: 13:27
  To change this template use File | Settings | File Templates.
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>


    </style>
    <%--    <link rel="stylesheet" href="css/addTask.css">--%>

</head>
<body>
<header class="main-header">
    <h1>simple<span>todo</span></h1>

    <a href="todoServlet?action=logout" class="home-button">Deconnecter</a>

</header>
<form method="post" action="todoServlet">
    <section class="app-insert">
        <input type="text" name="description" placeholder="ajouter un todo">
        <button type="submit">Ajouter</button>

    </section>
</form>
<section class="app-table">
    <table>
        <thead>
        <tr>
            <th>Todo</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="userTodos" scope="request" type="java.util.List" />
         <c:forEach var="todo" items="${userTodos}">
             <tr>
                 <td><c:out value="${todo.description}"/></td>
                 <%--
                 <td>
                     <a href="<%= request.getContextPath() %>/todoServlet?action=edit&id=${todo.todoList_id}" class="edit-button">Edit</a>
                     <a href="<%= request.getContextPath() %>/taskServlet?action=show&id=${todo.todoList_id}" class="show-button">Show</a>
                     <a href="<%= request.getContextPath() %>/todoServlet?action=delete&id=${todo.todoList_id}" class="delete-button">delete</a>
                 </td>
                 --%>
             </tr>
         </c:forEach>

        </tbody>
    </table>

</section>


</body>
</html>
