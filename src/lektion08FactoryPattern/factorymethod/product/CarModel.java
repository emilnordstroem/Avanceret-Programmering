package lektion08FactoryPattern.factorymethod.product;

public enum CarModel {
    FOCUS(CarBrand.FORD),
    MUSTANG(CarBrand.FORD),
    MAVERICK(CarBrand.FORD),

    ARTEON(CarBrand.VOLKSWAGEN),
    TROC(CarBrand.VOLKSWAGEN),
    AMAROK(CarBrand.VOLKSWAGEN),

    MODELS(CarBrand.TESLA),
    CYBERTRUCK(CarBrand.TESLA);

    private final CarBrand brand;

    CarModel(CarBrand brand) {
        this.brand = brand;
    }

}
