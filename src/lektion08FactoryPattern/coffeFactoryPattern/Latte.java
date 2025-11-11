package lektion08FactoryPattern.coffeFactoryPattern;

public class Latte implements Coffee {

    public Latte() {}

    @Override
    public void brew() {
        System.out.println("Brewing a Latte");
    }

    @Override
    public void serve() {
        System.out.println("Serving in a large glass");
    }
}
