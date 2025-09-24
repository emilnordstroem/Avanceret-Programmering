package lektion04Hashing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class HashSetLinearProbingTest {
    private HashSetLinearProbing names = new HashSetLinearProbing(10);

    @BeforeEach
    void setup () {
        names.add("Harry");
        names.add("Sue");
        names.add("Nina");
        names.add("Susannah");
        names.add("Larry");
    }

    @Test
    void add () {
        int actualResult = names.size();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void remove(){
        assertTrue(names.remove("Harry"));
        assertFalse(names.remove("Harry"));
    }
}