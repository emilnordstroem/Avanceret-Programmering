package lektion08FactoryPattern.factorymethod.product;

public abstract class Car {
    private CarBrand brand;
    private CarModel model;
    private int seats;
    private int doors;
    private FuelType fuelType;

    public Car(CarBrand brand, CarModel model, int seats, int doors, FuelType fuelType) {
        this.brand = brand;
        this.model = model;
        this.seats = seats;
        this.doors = doors;
        this.fuelType = fuelType;
    }

    public CarBrand getBrand() {
        return brand;
    }

    public CarModel getModel() {
        return model;
    }

    public int getSeats() {
        return seats;
    }

    public int getDoors() {
        return doors;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setBrand(CarBrand brand) {
        this.brand = brand;
    }

    public void setModel(CarModel model) {
        this.model = model;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }
}