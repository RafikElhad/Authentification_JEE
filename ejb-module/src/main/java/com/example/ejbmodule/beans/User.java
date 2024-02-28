package com.example.ejbmodule.beans;

import com.example.ejbmodule.entities.UserEntity;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.mindrot.jbcrypt.BCrypt;



@Stateless
public class User implements com.example.ejbmodule.pojos.User {
    @PersistenceContext(unitName = "todoPU")
    private EntityManager entityManager;

    @Override
    public void addUser(UserEntity user) {
       String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(user.getPassword(), salt);
        user.setPassword(hashedPassword);
        entityManager.persist(user);
    }
    @Override
    public UserEntity getUser(String password, String username) {
        try {
            UserEntity user = entityManager.createQuery("SELECT u FROM UserEntity u WHERE u.username = :username", UserEntity.class)
                    .setParameter("username", username)
                    .getSingleResult();

            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            } else {
                // Mot de passe incorrect
                return null;
            }
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
