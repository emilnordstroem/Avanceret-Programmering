package lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter;

import lektion07AdapterTemplatePattern.adapterPattern.spiritusadapter.superSalg.Spiritus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiritusAdapterTest {
    private Spiritus spiritus;
    private SpiritusAdapter adapter;

    @BeforeEach
    void setUp() {
        this.spiritus = new Spiritus(275, "Whiskey");
        this.adapter = new SpiritusAdapter(spiritus);
    }

    @Test
    void getPris() {
        int actualResult = adapter.getPris();
        assertEquals(275, actualResult);
    }

    @Test
    void getNavn() {
        String actualResult = adapter.getNavn();
        assertEquals("Whiskey", actualResult);
    }

    @Test
    void setPris() {
        adapter.setPris(299);
        int actualResult = adapter.getPris();
        int expectedResult = 299;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void setNavn() {
        adapter.setNavn("Rom");
        String actualResult = adapter.getNavn();
        String expextedResult = "Rom";
        assertEquals(expextedResult, actualResult);
    }

    @Test
    void beregnMoms() {
        double actualResult = adapter.beregnMoms();
        double expectedResult = adapter.getPris() * 0.25;
        assertEquals(expectedResult, actualResult);
    }
}