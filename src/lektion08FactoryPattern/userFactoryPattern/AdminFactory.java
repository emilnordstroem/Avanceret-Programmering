package lektion08FactoryPattern.userFactoryPattern;

public class AdminFactory extends UserFactory {

    public AdminFactory() {}

    @Override
    public User createUser() {
        return new Admin();
    }

}