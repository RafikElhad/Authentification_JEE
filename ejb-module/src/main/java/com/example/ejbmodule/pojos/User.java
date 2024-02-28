package com.example.ejbmodule.pojos;

import com.example.ejbmodule.entities.UserEntity;
import jakarta.ejb.Remote;

@Remote

public interface User {
    void addUser(UserEntity user);
    UserEntity getUser(String password, String username);
}
