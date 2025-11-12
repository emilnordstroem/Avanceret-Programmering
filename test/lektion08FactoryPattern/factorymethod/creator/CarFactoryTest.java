package lektion08FactoryPattern.factorymethod.creator;

import lektion08FactoryPattern.factorymethod.product.Car;
import lektion08FactoryPattern.factorymethod.product.CarBrand;
import lektion08FactoryPattern.factorymethod.product.CarModel;
import lektion08FactoryPattern.factorymethod.product.FuelType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    private CarFactory factory;

    @Test
    void createSedan() {
        factory = new SedanFactory();

        Car sedan = factory.createCar(
                CarBrand.FORD,
                CarModel.FOCUS,
                5,
                5,
                FuelType.GASOLINE
        );

        assertNotNull(sedan);
    }

    @Test
    void createConvertible() {
        factory = new ConvertibleFactory();

        Car convertible = factory.createCar(
                CarBrand.VOLKSWAGEN,
                CarModel.ARTEON,
                4,
                3,
                FuelType.ELECTRICITY
        );

        assertNotNull(convertible);
    }

    @Test
    void createIncompatibleConvertible() {
        assertThrows(UnsupportedOperationException.class, () -> {
            factory = new ConvertibleFactory();

            Car convertible = factory.createCar(
                    CarBrand.TESLA,
                    CarModel.CYBERTRUCK,
                    2,
                    3,
                    FuelType.ELECTRICITY
            );
        });
    }

    @Test
    void createPickup() {
        factory = new PickupFactory();

        Car pickup = factory.createCar(
                CarBrand.TESLA,
                CarModel.CYBERTRUCK,
                5,
                5,
                FuelType.ELECTRICITY
        );

        assertNotNull(pickup);
    }

}