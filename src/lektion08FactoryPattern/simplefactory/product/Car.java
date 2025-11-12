package lektion08FactoryPattern.simplefactory.product;

public abstract class Car {
    private int seats;
    private int doors;
    private FuelType fuelType;

    public Car(int seats, int doors, FuelType fuelType) {
        this.seats = seats;
        this.doors = doors;
        this.fuelType = fuelType;
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