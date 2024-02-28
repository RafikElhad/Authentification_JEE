
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 29/01/2024
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>


    </style>
    <%--    <link rel="stylesheet" href="css/addTask.css">--%>

</head>
<body>
<header class="main-header">
    <h1>simple<span>Task</span></h1>

    <a href="todoServlet" class="home-button">Home</a>

</header>
<form action="taskServlet" method="post">
    <section class="app-insert">
        <input type="text" name="description" placeholder="Insert your task here...">
        <input type="hidden" name="idTodo" value="${todoId}">
        <button type="submit">ADD</button>
    </section>
</form>
<section class="app-table">
    <table>
        <thead>
        <tr>
            <th>Task</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="tasksTodo" scope="request" type="java.util.List" />
        <c:forEach var="task" items="${tasksTodo}">
            <tr>
                <td><c:out value="${task.description}"/></td>
                <td>
                    <a href="<%= request.getContextPath() %>/taskServlet?action=edit&id=${task.id}">Edit</a>
                    <a href="<%= request.getContextPath() %>/taskServlet?action=show&id=${task.id}">Show</a>
                    <a href="<%= request.getContextPath() %>/taskServlet?action=delete&id=${task.id}">Delete</a>
                </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>
</section>


</body>
</html>
