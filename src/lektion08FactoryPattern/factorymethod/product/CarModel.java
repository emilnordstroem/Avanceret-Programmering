package lektion08FactoryPattern.factorymethod.product;

public enum CarModel {
    FOCUS("Ford"),
    MUSTANG("Ford"),
    MAVERICK("Ford"),

    ARTEON("Volkswagen"),
    TROC("Volkswagen"),
    AMAROK("Volkswagen"),

    MODELS("Tesla"),
    CYBERTRUCK("Tesla");

    private final String brand;

    CarModel(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

}
