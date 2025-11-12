package lektion08FactoryPattern.factorymethod.product;

public class Convertible extends Car {

    public Convertible(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        super(brand, model, seats, doors, fuelType);
    }

}
