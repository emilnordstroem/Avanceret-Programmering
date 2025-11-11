package lektion08FactoryPattern.userFactoryPattern;

public class Customer implements User {

    public Customer() {}

    @Override
    public void isAuthenticated() {
        System.out.println("This User is Authenticated");
    }

    @Override
    public void isAuthorized() {
        System.out.println("This User has NO Authority");
    }

    @Override
    public void printUser() {
        System.out.println("This is a Customer User");
    }
}
