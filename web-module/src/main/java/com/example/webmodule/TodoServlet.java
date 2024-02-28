package com.example.webmodule;


import com.example.ejbmodule.entities.TaskEntity;
import com.example.ejbmodule.entities.TodoEntity;
import com.example.ejbmodule.entities.UserEntity;
import com.example.ejbmodule.pojos.Todo;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoServlet", value = "/todoServlet")
public class TodoServlet extends HttpServlet {
    @EJB
    private Todo todo;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserEntity loggedInUser = (UserEntity) request.getSession().getAttribute("user");

        if (loggedInUser != null) {
            String action = request.getParameter("action");
            if ("edit".equalsIgnoreCase(action)) {
                handleEdit(request, response);
            } else if ("show".equalsIgnoreCase(action)) {
                handleShow(request, response);
            } else if ("delete".equalsIgnoreCase(action)) {
                handleDelete(request, response);
            }
            else if ("logout".equalsIgnoreCase(action)) {
                handleLogOut(request, response);
            }

            else {
                List<TodoEntity> userTodos = todo.getAllTodosByUserId(loggedInUser.getId());
                request.setAttribute("userTodos", userTodos);
                this.getServletContext().getRequestDispatcher("/listTodo.jsp").forward(request, response);            }

        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        UserEntity loggedInUser = (UserEntity) request.getSession().getAttribute("user");

        TodoEntity todo = new TodoEntity();
        todo.setDescription(description);
        todo.setUtilisateur(loggedInUser);
        this.todo.addTodo(todo);

        response.sendRedirect(request.getContextPath() + "/todoServlet");

    }

    private void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String todoIdString = request.getParameter("id");
        Long todoId = Long.parseLong(todoIdString);


        TodoEntity todo = this.todo.getTodoById(todoId);

        request.setAttribute("editedTodo",todo);

        request.getRequestDispatcher("/updateTodo.jsp").forward(request, response);}

    private void handleShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String todoIdString = request.getParameter("id");
        Long todoId = Long.parseLong(todoIdString);


        List<TaskEntity> tasksTodo = todo.getAllTaskByTodo(todoId);

        request.setAttribute("tasksTodo",tasksTodo);
        request.setAttribute("todoId",todoId);

        request.getRequestDispatcher("/listTask.jsp").forward(request, response);    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String todoIdString = request.getParameter("id");
        Long todoId = Long.parseLong(todoIdString);

        todo.deleteTodoById(todoId);

        response.sendRedirect(request.getContextPath() + "/todoServlet");
    }

    private void handleLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().invalidate();

        response.sendRedirect(request.getContextPath() + "/loginServlet");
    }




    public void destroy() {
    }

}
