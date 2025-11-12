package lektion08FactoryPattern.simplefactory.creator;

import lektion08FactoryPattern.simplefactory.product.*;

public class CarFactory {

    public CarFactory() {}

    // Simple Factory
    public Car createCar(CarType carType, int seats, int doors, FuelType fuelType) {
        if (carType == CarType.SEDAN) {
            return new Sedan(seats, doors, fuelType);
        } else if (carType == CarType.CONVERTIBLE) {
            return new Convertible(seats, doors, fuelType);
        } else if (carType == CarType.PICKUP) {
            return new Pickup(seats, doors, fuelType);
        }
        return null;
    }

}