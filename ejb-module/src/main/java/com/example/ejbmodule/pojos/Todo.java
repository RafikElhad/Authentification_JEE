package com.example.ejbmodule.pojos;


import com.example.ejbmodule.entities.TaskEntity;
import com.example.ejbmodule.entities.TodoEntity;
import jakarta.ejb.Remote;

import java.util.List;

@Remote
public interface Todo {
    void  addTodo(TodoEntity todo);
    TodoEntity getTodoById(Long todoId);

    List<TodoEntity> getAllTodosByUserId(Long userId);

    List<TaskEntity> getAllTaskByTodo(Long todoId);

    void updateTodo(TodoEntity todo);

    void deleteTodoById(Long todoId);
}
