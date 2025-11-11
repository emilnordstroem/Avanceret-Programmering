package lektion08FactoryPattern.coffeFactoryPattern;

public abstract class CoffeeShop {

    public CoffeeShop() {}

    public void newOrder (CoffeeType type) {
        Coffee coffee = createCoffee(type);

        coffee.brew();
        coffee.serve();
    }

    protected abstract Coffee createCoffee(CoffeeType type);

}
