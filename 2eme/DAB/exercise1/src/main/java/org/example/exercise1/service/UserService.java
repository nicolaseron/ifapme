package org.example.exercise1.service;

import org.example.exercise1.model.User;

import java.util.List;

public interface UserService {
    String createUser(User user);

    List<User> findAll();

    void deleteUser(int id);

    User updateUser(User user);

    void addMultipleUsers(User user, int nb);

    boolean checkUserExist(User user);
}
