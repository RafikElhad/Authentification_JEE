package com.example.ejbmodule.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


@Entity

public class UserEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "utilisateur")
    private List<TodoEntity> todoLists;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTodoLists(List<TodoEntity> todoLists) {
        this.todoLists = todoLists;
    }

    public List<TodoEntity> getTodoLists() {
        return todoLists;
    }
}
