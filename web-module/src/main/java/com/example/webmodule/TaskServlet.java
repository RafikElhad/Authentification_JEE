package com.example.webmodule;

import com.example.ejbmodule.entities.TaskEntity;
import com.example.ejbmodule.entities.TodoEntity;
import com.example.ejbmodule.entities.UserEntity;
import com.example.ejbmodule.pojos.Task;
import com.example.ejbmodule.pojos.Todo;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "taskServlet" , value = "/taskServlet")
public class TaskServlet extends HttpServlet
{
    @EJB
    private Task task;
    @EJB
    private Todo todo;


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        UserEntity loggedInUser = (UserEntity) request.getSession().getAttribute("user");

        if (loggedInUser != null) {
            String action = request.getParameter("action");
            if ("edit".equalsIgnoreCase(action)) {
                handleEdit(request, response);
            } else if ("showDetail".equalsIgnoreCase(action)) {
                handleShow(request, response);
            } else if ("delete".equalsIgnoreCase(action)) {
                handleDelete(request, response);
            } else if ("show".equalsIgnoreCase(action)) {
                handleShowAllTask(request,response);
            } else {

                handleShowAllTask(request,response);            }

        } else {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String todoIdString = request.getParameter("idTodo");
        Long todoId = Long.parseLong(todoIdString);
        TodoEntity todo = this.todo.getTodoById(todoId);
        TaskEntity task = new TaskEntity();
        task.setDescription(description);
        task.setTodoList(todo);
        this.task.addTask(task);

        response.sendRedirect(request.getContextPath() + "/taskServlet?id=" + todoId);

    }

    private void handleEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskIdString = request.getParameter("id");
        Long taskId = Long.parseLong(taskIdString);


        TaskEntity task = this.task.getTaskById(taskId);

        request.setAttribute("editedTask",task);

        request.getRequestDispatcher("/udpadeTask.jsp").forward(request, response);}

    private void handleShowAllTask(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String todoIdString = request.getParameter("id");
        Long todoId = Long.parseLong(todoIdString);

        TodoEntity todo = this.todo.getTodoById(todoId);

        List<TaskEntity> tasksTodo = task.getAllTaskByTodo(todoId);

        request.setAttribute("tasksTodo",tasksTodo);
        request.setAttribute("todoId",todoId);

        request.getRequestDispatcher("/listTask.jsp").forward(request, response);    }

    private void handleShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskIdString = request.getParameter("id");
        Long taskId = Long.parseLong(taskIdString);


        TaskEntity task = this.task.getTaskById(taskId);

        request.setAttribute("showTask",task);


        request.getRequestDispatcher("/showTask.jsp").forward(request, response);    }

    private void handleDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String taskIdString = request.getParameter("id");
        Long taskId = Long.parseLong(taskIdString);
        TaskEntity task = this.task.getTaskById(taskId);
        Long todoId = task.getTodoList().getTodoList_id();

        this.task.deleteTaskById(taskId);

        response.sendRedirect(request.getContextPath() + "/taskServlet?id=" + todoId);

    }




    public void destroy() {
    }


//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        response.setContentType("text/html");
//
//
//        this.getServletContext().getRequestDispatcher("/listTask.jsp").forward(request, response);
//
//    }






}
