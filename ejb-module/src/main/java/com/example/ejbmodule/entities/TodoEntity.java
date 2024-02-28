package com.example.ejbmodule.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
public class TodoEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoList_id;

    private String description;

    @ManyToOne
    private UserEntity utilisateur;

    @OneToMany(mappedBy = "todoList", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<TaskEntity> tasks;

    public Long getTodoList_id() {
        return todoList_id;
    }

    public void setTodoList_id(Long todoList_id) {
        this.todoList_id = todoList_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserEntity getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UserEntity utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
