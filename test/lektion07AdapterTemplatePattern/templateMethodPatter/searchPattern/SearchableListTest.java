package lektion07AdapterTemplatePattern.templateMethodPatter.searchPattern;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearchableListTest {
    private SearchPattern<String> list;

    @BeforeEach
    void setUp() {
        List<String> stringList = List.of(
                "Holme",
                "Skåde",
                "Viby",
                "Beder",
                "Stautrup",
                "Engdal",
                "Forældreskolen",
                "Malling"
        );
        list = new SearchableList<>(stringList);
    }

    @Test
    void succeededSearch() {
        boolean actualResult = list.search("Malling");
        assertTrue(actualResult);
    }

    @Test
    void failedSearch() {
        boolean actualResult = list.search("Riskov");
        assertFalse(actualResult);
    }

}