package lektion08FactoryPattern.factorymethod.creator;

import lektion08FactoryPattern.factorymethod.product.*;

public class ConvertibleFactory extends CarFactory {

    @Override
    public Car createCar(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        if (brand == CarBrand.TESLA) {
            throw new UnsupportedOperationException();
        }
        return new Convertible(brand, model, seats, doors, fuelType);
    }

}
