package lektion08FactoryPattern.simplefactory.creator;

import lektion08FactoryPattern.simplefactory.product.Car;
import lektion08FactoryPattern.simplefactory.product.CarType;
import lektion08FactoryPattern.simplefactory.product.FuelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    private CarFactory factory;

    @BeforeEach
    void initial () {
        factory = new CarFactory();
    }

    @Test
    void createCar() {
        Car actualResult = factory.createCar(
                CarType.SEDAN,
                5,
                5,
                FuelType.ELECTRICITY
        );
        assertNotNull(actualResult);
    }

}