package lektion08FactoryPattern.coffeFactoryPattern;

public class AmericanCoffeeShop extends CoffeeShop {

    public AmericanCoffeeShop() {}

    @Override
    protected Coffee createCoffee(CoffeeType type) {
        return switch (type) {
            case LATTE -> new Latte();
            case ESPRESSO -> new Espresso();
        };
    }

}
