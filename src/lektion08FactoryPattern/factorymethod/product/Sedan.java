package lektion08FactoryPattern.factorymethod.product;

public class Sedan extends Car {

    public Sedan(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        super(brand, model, seats, doors, fuelType);
    }

}
