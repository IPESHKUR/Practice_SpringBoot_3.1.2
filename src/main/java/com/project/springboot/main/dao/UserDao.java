package com.project.springboot.main.dao;


import com.project.springboot.main.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(Long id);

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUsers(Long id);

    void updateUser(User user);


}
