package com.project.springboot.main.dao;

import com.project.springboot.main.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUserById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("User with this ID not found");
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void deleteUsers(Long id) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            throw new EntityNotFoundException("It is not possible to delete a user with this ID");
        }
        entityManager.remove(user);
    }

    @Override
    public void updateUser(User user) {
        if (user == null) {
            throw new EntityNotFoundException("It is not possible to update this user");
        }
        entityManager.merge(user);
    }
}
