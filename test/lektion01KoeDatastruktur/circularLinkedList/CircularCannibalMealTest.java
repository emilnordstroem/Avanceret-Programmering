package lektion01KoeDatastruktur.circularLinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CircularCannibalMealTest {
    private CircularCannibalMeal linkedList;

    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;
    private Person person5;

    @BeforeEach
    void setup() {

        this.linkedList = new CircularCannibalMeal();

        person1 = new Person("1");
        person2 = new Person("2");
        person3 = new Person("3");
        person4 = new Person("4");
        person5 = new Person("5");

    }

    @Test
    void addPerson() {
        linkedList.addPerson(person1);
        assertEquals(linkedList.getCurrentSize(), 1);
        linkedList.addPerson(person2);
        assertEquals(linkedList.getCurrentSize(), 2);
        linkedList.addPerson(person3);
        assertEquals(linkedList.getCurrentSize(), 3);
        linkedList.addPerson(person4);
        assertEquals(linkedList.getCurrentSize(), 4);
        linkedList.addPerson(person5);
        assertEquals(linkedList.getCurrentSize(), 5);
    }

    @Test
    void eatRandomPerson() {
        linkedList.addPerson(person1);
        linkedList.addPerson(person2);
        linkedList.addPerson(person3);
        linkedList.addPerson(person4);
        linkedList.addPerson(person5);

        assertNotNull(linkedList.eatRandomPerson());
        assertNotNull(linkedList.eatRandomPerson());
        assertNotNull(linkedList.eatRandomPerson());
        assertNotNull(linkedList.eatRandomPerson());
        assertNotNull(linkedList.eatRandomPerson());
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.eatRandomPerson();
        });
    }

    @Test
    void eatNextPerson() {
        linkedList.addPerson(person1);
        linkedList.addPerson(person2);
        linkedList.addPerson(person3);
        linkedList.addPerson(person4);
        linkedList.addPerson(person5);

        assertNotNull(linkedList.eatNextPerson(1));
        assertNotNull(linkedList.eatNextPerson(2));
        assertNotNull(linkedList.eatNextPerson(3));
        assertNotNull(linkedList.eatNextPerson(4));
        assertNotNull(linkedList.eatNextPerson(5));
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.eatRandomPerson();
        });
    }

    @Test
    void printPersons() {
        assertThrows(NoSuchElementException.class, () -> {
            linkedList.printPersons();
        });
        linkedList.addPerson(person1);
        linkedList.printPersons();
        System.out.println();
        linkedList.addPerson(person2);
        linkedList.printPersons();
        System.out.println();
        linkedList.addPerson(person3);
        linkedList.printPersons();
        System.out.println();
        linkedList.addPerson(person4);
        linkedList.printPersons();
        System.out.println();
        linkedList.addPerson(person5);
        linkedList.printPersons();
    }

}