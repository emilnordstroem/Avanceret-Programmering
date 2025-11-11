package lektion08FactoryPattern.userFactoryPattern;

public class CustomerFactory extends UserFactory {

    public CustomerFactory() {}

    @Override
    public User createUser() {
        return new Customer();
    }

}