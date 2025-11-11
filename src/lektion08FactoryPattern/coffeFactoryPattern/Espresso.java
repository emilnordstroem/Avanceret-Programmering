package lektion08FactoryPattern.coffeFactoryPattern;

public class Espresso implements Coffee {

    public Espresso() {}

    @Override
    public void brew() {
        System.out.println("Brewing an Espresso");
    }

    @Override
    public void serve() {
        System.out.println("Serving in a small cup");
    }

}
