package lektion08FactoryPattern;

import lektion08FactoryPattern.coffeFactoryPattern.AmericanCoffeeShop;
import lektion08FactoryPattern.coffeFactoryPattern.CoffeeShop;
import lektion08FactoryPattern.coffeFactoryPattern.CoffeeType;
import lektion08FactoryPattern.userFactoryPattern.AdminFactory;
import lektion08FactoryPattern.userFactoryPattern.CustomerFactory;
import lektion08FactoryPattern.userFactoryPattern.User;
import lektion08FactoryPattern.userFactoryPattern.UserFactory;

public class Main {

    public static void main(String[] args) {
        CoffeeShop starbucks = new AmericanCoffeeShop();
        starbucks.newOrder(CoffeeType.ESPRESSO);

        UserFactory adminFactory = new AdminFactory();
        UserFactory customerFactory = new CustomerFactory();

        User adminUser = adminFactory.createUser();
        User customerUser = customerFactory.createUser();

        adminUser.isAuthorized();
        customerUser.isAuthorized();

    }

}