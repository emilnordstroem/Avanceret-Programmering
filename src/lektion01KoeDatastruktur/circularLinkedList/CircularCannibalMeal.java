package lektion01KoeDatastruktur.circularLinkedList;

import java.util.NoSuchElementException;
import java.util.Random;

public class CircularCannibalMeal {
    private Person head;
    private Person lastEatenPerson;
    private int currentSize = 0;

    public CircularCannibalMeal() {}

    public void addPerson(Person person) { // Adds person to the cannibal dance meal
        if (head == null) {
            head = person;
            head.setNextPerson(head);
        } else {
            Person currentPerson = head;
            while (currentPerson.hasNext()) {
                if (currentPerson.next() == head) {
                    break;
                }
                currentPerson = currentPerson.next();
            }
            currentPerson.setNextPerson(person);
            person.setNextPerson(head);
        }
        currentSize++;
    }

    public Person eatRandomPerson() { // Removes random person from the cannibal dance
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }

        Person currentPersonToBeEaten = head;

        int randomCountFromBasePerson = new Random().nextInt(0,10);
        for (int counter = 0; counter < randomCountFromBasePerson; counter++) {
            currentPersonToBeEaten = currentPersonToBeEaten.getNextPerson();
        }

        Person previousPerson = null;
        for (int counter = 0; counter < 5; counter++) {
            previousPerson = currentPersonToBeEaten;
            currentPersonToBeEaten = currentPersonToBeEaten.getNextPerson();
        }

        previousPerson.setNextPerson(currentPersonToBeEaten.getNextPerson());
        currentSize--;

        if (currentPersonToBeEaten == head) {
            head = currentPersonToBeEaten.getNextPerson();
        }
        lastEatenPerson = currentPersonToBeEaten;
        return lastEatenPerson;
    }

    public Person eatNextPerson(int count) { // Removes person "count" places from the last eaten
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }

        Person currentPersonToBeEaten = (lastEatenPerson == null) ? head : lastEatenPerson.getNextPerson();
        Person previousPerson = null;

        for (int currentCount = 0; currentCount < count; currentCount++) {
            previousPerson = currentPersonToBeEaten;
            currentPersonToBeEaten = currentPersonToBeEaten.getNextPerson();
        }

        if (previousPerson == null) {
            Person personBeforeHead = head;
            while (personBeforeHead.getNextPerson() != head) {
                personBeforeHead = personBeforeHead.getNextPerson();
            }
            head = head.getNextPerson();
            personBeforeHead.setNextPerson(head);
        } else {
            previousPerson.setNextPerson(currentPersonToBeEaten.getNextPerson());
            if (currentPersonToBeEaten == head) {
                head = currentPersonToBeEaten.getNextPerson();
            }
        }

        lastEatenPerson = currentPersonToBeEaten;
        currentSize--;
        return lastEatenPerson;
    }

    public void printPersons() { // Prints all persons waiting to be serve
        if (currentSize == 0) {
            throw new NoSuchElementException();
        }
        Person currentPerson = head;
        System.out.println(currentPerson.getName());
        while (currentPerson.hasNext() && currentPerson.next() != head) {
            System.out.println(currentPerson.next().getName());
            currentPerson = currentPerson.next();
        }
    }

    public int getCurrentSize() {
        return currentSize;
    }
}
