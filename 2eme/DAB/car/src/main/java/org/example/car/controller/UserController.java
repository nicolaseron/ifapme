package org.example.car.controller;

import org.example.car.exception.BusinessException;
import org.example.car.model.User;
import org.example.car.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "api/user")
public class UserController {

    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userService = userServiceImpl;
    }

    @GetMapping
    public User getUsers() {
        return userService.findById(1);
    }

    @PostMapping
    public User createUser(@RequestBody User user) throws BusinessException {
        return userService.createUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) throws BusinessException {
        return userService.updateUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Integer id) throws BusinessException {
        userService.deleteUser(id);
    }
}
