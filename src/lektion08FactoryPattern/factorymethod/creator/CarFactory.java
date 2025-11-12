package lektion08FactoryPattern.factorymethod.creator;
import lektion08FactoryPattern.factorymethod.product.*;

public abstract class CarFactory {

    public CarFactory() {}

    abstract public Car createCar(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType);

}