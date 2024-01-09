package com.project.springboot.main.service;


import com.project.springboot.main.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    void saveUser(User user);

    void deleteUsers(Long id);

    void updateUser(User user);
}
