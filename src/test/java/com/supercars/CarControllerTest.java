
package com.supercars;

import com.supercars.controller.CarController;
import com.supercars.entity.Car;
import com.supercars.service.CarService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CarControllerTest {

    @Autowired
    private CarController carController;

    @MockBean
    private CarService carService;

    @Test
    public void testGetCarById() {
        Car car = new Car();
        car.setId(1L);
        car.setMake("Ferrari");
        car.setModel("SF90");
        car.setYear(2022);
        car.setPrice(500000);

        Mockito.when(carService.getCarById(1L)).thenReturn(Optional.of(car));

        ResponseEntity<Car> response = carController.getCarById(1L);
        assertThat(response.getBody()).isEqualTo(car);
    }
}
