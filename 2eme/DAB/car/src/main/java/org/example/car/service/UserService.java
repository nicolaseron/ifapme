package org.example.car.service;

import org.example.car.exception.BusinessException;
import org.example.car.exception.UserAlreadyExistException;
import org.example.car.exception.UserNotFoundException;
import org.example.car.model.Car;
import org.example.car.model.User;

import java.util.List;

public interface UserService {
    User findById(Integer id);

    User createUser(User user) throws BusinessException;

    User updateUser(User user) throws BusinessException;

    void deleteUser(Integer id) throws BusinessException;

    List<Car> findAllCarsByUser(Integer userId) throws BusinessException;
}
