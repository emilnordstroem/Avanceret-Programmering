package lektion06IteratorPattern.personcollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PersonCollectionTest {
    private final PersonCollection personCollection = new PersonCollection();
    private Iterator<Person> personIterator;

    @BeforeEach
    void setUp() {
        personCollection.add(new Person("Kasper"));
        personCollection.add(new Person("Jesper"));
        personCollection.add(new Person("Jens"));
        personCollection.add(new Person("Martin"));
        personCollection.add(new Person("Mikkel"));

        personIterator = personCollection.iterator();
    }

    @Test
    void iterator() {
        assertNotNull(personIterator);
    }

    @Test
    void hasCollectionNext() {
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());

        assertFalse(personIterator.hasNext());
        assertNull(personIterator.next());
    }

    @Test
    void remove() {
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        personIterator.remove();
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        personIterator.remove();
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        personIterator.remove();
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        personIterator.remove();
        assertTrue(personIterator.hasNext());
        assertNotNull(personIterator.next());
        personIterator.remove();

        assertFalse(personIterator.hasNext());
        assertNull(personIterator.next());
    }

    @Test
    void fastFail() {
        assertThrows(ConcurrentModificationException.class, () -> {
            int pointOfFailure = 3;
            while (personIterator.hasNext()) {
                if (pointOfFailure == 0) {
                    personCollection.remove(pointOfFailure);
                } else {
                    pointOfFailure--;
                }
                personIterator.next();
            }
        });
    }

}