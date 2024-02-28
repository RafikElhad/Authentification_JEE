package com.example.webmodule;


import com.example.ejbmodule.entities.TodoEntity;
import com.example.ejbmodule.pojos.Todo;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateTodoServlet", value = "/updateTodoServlet")

public class UpdateTodoServlet extends HttpServlet {
    @EJB
    private Todo todo;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String todoIdString = request.getParameter("id");
        Long todoId = Long.parseLong(todoIdString);


        TodoEntity todo = this.todo.getTodoById(todoId);

        todo.setDescription(description);
        this.todo.updateTodo(todo);

        response.sendRedirect(request.getContextPath() + "/todoServlet");

    }
}
