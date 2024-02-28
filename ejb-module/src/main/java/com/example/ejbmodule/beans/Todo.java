package com.example.ejbmodule.beans;


import com.example.ejbmodule.entities.TaskEntity;
import com.example.ejbmodule.entities.TodoEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Stateless
public class Todo implements com.example.ejbmodule.pojos.Todo {
    @PersistenceContext(unitName = "todoPU")
    private EntityManager entityManager;
    @Override
    public void  addTodo(TodoEntity todo){
        entityManager.persist(todo);
    }
    @Override
    public TodoEntity getTodoById(Long TodoId) {
        return entityManager.find(TodoEntity.class, TodoId);
    }
    @Override
    public List<TodoEntity> getAllTodosByUserId(Long userId) {
        TypedQuery<TodoEntity> query = entityManager.createQuery(
                        "SELECT t FROM TodoEntity t WHERE t.utilisateur.Id = :userId", TodoEntity.class)
                .setParameter("userId", userId);
        return query.getResultList();
    }
    @Override
    public List<TaskEntity> getAllTaskByTodo(Long todoId) {
        TypedQuery<TaskEntity> query = entityManager.createQuery(
                        "SELECT t FROM TaskEntity t WHERE t.todoList.todoList_id = :todoId", TaskEntity.class)
                .setParameter("todoId", todoId);
        return query.getResultList();
    }
    @Override
    public void updateTodo(TodoEntity todo) {
        entityManager.merge(todo);
    }
    @Override
    public void deleteTodoById(Long todoId) {
        TodoEntity todo = getTodoById(todoId);
        if (todo != null) {
            entityManager.remove(todo);
        }
    }
}
