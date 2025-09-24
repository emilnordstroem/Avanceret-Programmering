package lektion04Hashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashSetChainingTest {
    private HashSetChaining names = new HashSetChaining(10);

    @Test
    void remove() {
        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");

        assertTrue(names.remove("Harry"));
        assertFalse(names.contains("Harry"));
        assertFalse(names.remove("Emil"));
    }

    @Test
    void rehash() {
        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");
        names.add("Eve");
        int actualResult = names.size();
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);

        names.add("Sarah");
        names.add("Adam");
        names.add("Tony");
        names.add("Katherine");
        names.add("Juliet");
        names.add("Romeo");
        actualResult = names.size();
        expectedResult = 12;
        assertEquals(expectedResult, actualResult);

    }

}