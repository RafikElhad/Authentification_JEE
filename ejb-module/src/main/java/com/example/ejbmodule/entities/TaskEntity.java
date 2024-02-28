package com.example.ejbmodule.entities;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
public class TaskEntity  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    private TodoEntity todoList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoEntity getTodoList() {
        return todoList;
    }

    public void setTodoList(TodoEntity todoList) {
        this.todoList = todoList;
    }
}
