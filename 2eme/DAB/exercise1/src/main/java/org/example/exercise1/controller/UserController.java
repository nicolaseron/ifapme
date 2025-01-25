package org.example.exercise1.controller;

import org.example.exercise1.model.User;
import org.example.exercise1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("users")
    public List<User> getUsers() {
        return this.userService.findAll();
    }

    @PostMapping("user")
    public String createUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping("change-user")
    public User changeUser(@RequestBody User user) {
        return this.userService.updateUser(user);
    }

    @DeleteMapping("delete-user/{id}")
    public void deleteUser(@PathVariable int id) {
        this.userService.deleteUser(id);
    }

    @PostMapping("users/{nbrUser}")
    public void addMultipleUser(@RequestBody User user, @PathVariable int nbrUser) {
        this.userService.addMultipleUsers(user, nbrUser);
    }

}
