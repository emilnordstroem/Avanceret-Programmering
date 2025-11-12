package lektion08FactoryPattern.factorymethod.creator;

import lektion08FactoryPattern.factorymethod.product.*;

public class SedanFactory extends CarFactory {

    @Override
    public Car createCar(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        return new Sedan(brand, model, seats, doors, fuelType);
    }

}
