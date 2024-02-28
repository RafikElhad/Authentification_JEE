package com.example.webmodule;


import com.example.ejbmodule.entities.TaskEntity;
import com.example.ejbmodule.pojos.Task;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "UpdateTaskServlet", value = "/updateTaskServlet")

public class UpdateTaskServlet extends HttpServlet {
    @EJB
    private Task task;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String taskIdString = request.getParameter("id");
        Long taskId = Long.parseLong(taskIdString);

        TaskEntity task = this.task.getTaskById(taskId);
        task.setDescription(description);
        this.task.updateTask(task);
        Long todoId = task.getId();
        response.sendRedirect(request.getContextPath() + "/taskServlet?id=" + todoId);

    }
}
