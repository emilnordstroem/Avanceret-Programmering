package lektion08FactoryPattern.factorymethod.product;

public class Pickup extends Car {

    public Pickup(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        super(brand, model, seats, doors, fuelType);
    }
}
