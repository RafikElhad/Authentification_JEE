package com.example.ejbmodule.beans;


import com.example.ejbmodule.entities.TaskEntity;
import com.example.ejbmodule.entities.TodoEntity;
import com.example.ejbmodule.pojos.Todo;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Stateless
public class Task implements com.example.ejbmodule.pojos.Task {
    @PersistenceContext(unitName = "todoPU")
    private EntityManager entityManager;
@EJB
private Todo todo;

  @Override
    public void addTask(TaskEntity task) {
      entityManager.persist(task);
  }
  @Override
  public TaskEntity getTaskById(Long taskId) {
      return entityManager.find(TaskEntity.class, taskId);
  }
  @Override
  public void updateTask(TaskEntity task) {
      entityManager.merge(task);

  }
  @Override
    public List<TaskEntity> getAllTaskByTodo(Long todoId) {
      TodoEntity todo = this.todo.getTodoById(todoId);
      return todo.getTasks();
  }
  @Override
  public void deleteTaskById(Long todoId) {
      TaskEntity task = getTaskById(todoId);
      if (task != null) {
          entityManager.remove(task);
      }
  }
}
