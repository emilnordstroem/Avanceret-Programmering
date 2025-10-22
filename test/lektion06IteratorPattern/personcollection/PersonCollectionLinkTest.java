package lektion06IteratorPattern.personcollection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class PersonCollectionLinkTest {
    private final PersonCollectionLink personCollectionLink = new PersonCollectionLink();
    private Iterator<Person> personIterator;

    @BeforeEach
    void setUp() {
        personCollectionLink.add(new Person("Kasper"));
        personCollectionLink.add(new Person("Jesper"));
        personCollectionLink.add(new Person("Jens"));
        personCollectionLink.add(new Person("Martin"));
        personCollectionLink.add(new Person("Mikkel"));

        personIterator = personCollectionLink.iterator();
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
    }

    @Test
    void fastFail() {
        assertThrows(ConcurrentModificationException.class, () -> {
            int pointOfFailure = 3;
            while (personIterator.hasNext()) {
                if (pointOfFailure == 0) {
                    personCollectionLink.remove(pointOfFailure);
                } else {
                    pointOfFailure--;
                }
                personIterator.next();
            }
        });
    }

}