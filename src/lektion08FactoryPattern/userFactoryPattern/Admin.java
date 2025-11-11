package lektion08FactoryPattern.userFactoryPattern;

public class Admin implements User {

    public Admin() {}

    @Override
    public void isAuthenticated() {
        System.out.println("This User is Authenticated");
    }

    @Override
    public void isAuthorized() {
        System.out.println("This User has Authority");
    }

    @Override
    public void printUser() {
        System.out.println("This is an Administrative User");
    }
}
