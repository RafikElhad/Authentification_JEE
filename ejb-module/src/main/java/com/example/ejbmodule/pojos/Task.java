package com.example.ejbmodule.pojos;

import com.example.ejbmodule.entities.TaskEntity;
import jakarta.ejb.Remote;

import java.util.List;

@Remote

public interface Task {
   void addTask(TaskEntity task);
   TaskEntity getTaskById(Long taskId);

   List<TaskEntity> getAllTaskByTodo(Long todoId);

    void updateTask(TaskEntity task);

    void deleteTaskById(Long todoId);

}
