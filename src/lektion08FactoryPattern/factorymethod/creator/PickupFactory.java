package lektion08FactoryPattern.factorymethod.creator;

import lektion08FactoryPattern.factorymethod.product.*;

public class PickupFactory extends CarFactory {

    @Override
    public Car createCar(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        return new Pickup(brand, model, seats, doors, fuelType);
    }

}