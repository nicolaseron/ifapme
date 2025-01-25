package org.example.exercise1.service.impl;

import org.example.exercise1.model.User;
import org.example.exercise1.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<User> users = new ArrayList<User>();

    @Override
    public boolean checkUserExist(User user) {
        return this.users.stream().anyMatch(u -> u.getId() == user.getId());
    }

    @Override
    public String createUser(User user) {
        boolean isUserExist = checkUserExist(user);
        if (isUserExist) {
            return "Désoler mais l'id n°" + user.getId() + " existe déjà !";
        }
        this.users.add(user);
        return "User créer : " + user.toString();
    }

    @Override
    public List<User> findAll() {
        return this.users;
    }

    @Override
    public void deleteUser(int id) {
        this.users.removeIf(user -> user.getId() == id);
    }

    @Override
    public User updateUser(User user) {
        User userToBeUpdated = this.users.stream().filter(u -> user.getId() == u.getId()).findFirst().orElse(null);
        if (!user.getFirstName().isEmpty()) {
            userToBeUpdated.setFirstName(user.getFirstName());
        }
        if (!user.getLastName().isEmpty()) {
            userToBeUpdated.setLastName(user.getLastName());
        }
        return userToBeUpdated;
    }

    @Override
    public void addMultipleUsers(User user, int nbrUser) {
        this.users.add(user);
        for (int i = 1; i < nbrUser; i++) {
            User newUser = new User();
            newUser.setId(user.getId() + i);
            newUser.setFirstName(user.getFirstName() + "-" + i);
            newUser.setLastName(user.getLastName() + "-" + i);
            this.users.add(newUser);
        }
    }

}
