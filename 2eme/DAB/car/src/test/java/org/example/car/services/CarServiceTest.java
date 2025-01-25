package org.example.car.services;

import org.example.car.exception.BusinessException;
import org.example.car.model.*;
import org.example.car.repository.CarRepository;
import org.example.car.repository.ModelRepository;
import org.example.car.service.CarService;
import org.example.car.service.UserService;
import org.example.car.service.impl.CarServiceImpl;
import org.example.car.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @Mock
    CarRepository carRepository;
    @Mock
    ModelRepository modelRepository;

    @InjectMocks
    CarServiceImpl carService;

    User user = new User(1 , "Nico");
    Marque marque = new Marque(1  , "BMW");
    Model model = new Model(1 , "X1" , marque);
    Car car = new Car("1-szz-614", Color.BLUE , user , model);

    @BeforeEach
    void setUp() {
        when(carRepository.findById("1-szz-614")).thenReturn(Optional.of(car));
        when(carRepository.findById("fhfos")).thenReturn(Optional.empty());
    }

    @Test
    void findById() throws BusinessException {
        Car actualCar = carService.getById("1-szz-614");
        assertSame(actualCar, car);
        assertNull(carService.getById("fhfos"));
    }
}
