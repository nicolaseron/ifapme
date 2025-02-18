package org.example.car.service.impl;

import org.example.car.exception.BusinessException;
import org.example.car.exception.UserAlreadyExistException;
import org.example.car.exception.UserHasCarException;
import org.example.car.exception.UserNotFoundException;
import org.example.car.model.Car;
import org.example.car.model.User;
import org.example.car.repository.CarRepository;
import org.example.car.repository.UserRepository;
import org.example.car.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final CarRepository carRepository;

    public UserServiceImpl(UserRepository userRepository, CarRepository carRepository) {
        this.userRepository = userRepository;
        this.carRepository = carRepository;
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User createUser(User user) throws BusinessException {
        if (this.findById(user.getId()) == null) {
            return userRepository.save(user);
        } else {
            throw new UserAlreadyExistException();
        }
    }

    ;

    @Override
    public User updateUser(User user) throws BusinessException {
        if (this.findById(user.getId()) == null) {
            throw new UserNotFoundException(user.getId());
        }
        return userRepository.save(user);
    }

    ;

    @Override
    public void deleteUser(Integer userId) throws BusinessException {
        User userToDelete = this.findById(userId);
        List<Car> userCar = carRepository.findByUserId(userId);
        if (!userCar.isEmpty()) {
            List<String> plaques = userCar.stream().map(Car::getPlaqueNumber).toList();
            throw new UserHasCarException(userId, plaques);
        }
        if (userToDelete == null) {
            throw new UserNotFoundException(userId);
        } else {
            this.userRepository.delete(userToDelete);
        }
    }

    @Override
    public List<Car> findAllCarsByUser(Integer userId) throws BusinessException {
        User user = this.findById(userId);
        if (user == null) {
            throw new UserNotFoundException(userId);
        }
        return carRepository.findByUserId(userId);
    };
}