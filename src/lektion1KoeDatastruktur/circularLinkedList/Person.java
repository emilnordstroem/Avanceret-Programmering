package lektion1KoeDatastruktur.circularLinkedList;

import java.util.Iterator;

public class Person implements Iterator<Person> {
    private final String name;
    private Person nextPerson;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Person getNextPerson() {
        return nextPerson;
    }

    public void setNextPerson(Person nextPerson) {
        this.nextPerson = nextPerson;
    }

    @Override
    public boolean hasNext() {
        return nextPerson != null;
    }

    @Override
    public Person next() {
        return nextPerson;
    }
}
