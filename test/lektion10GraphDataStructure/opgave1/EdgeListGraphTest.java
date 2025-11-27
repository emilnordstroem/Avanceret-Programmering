package lektion10GraphDataStructure.opgave1;

import lektion10GraphDataStructure.Edge;
import lektion10GraphDataStructure.EdgeListGraph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EdgeListGraphTest {
    private EdgeListGraph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new EdgeListGraph<>();
    }

    @Test
    void addVertex() {
        graph.addVertex(15);
        graph.addVertex(38);
        graph.addVertex(123);
        graph.addVertex(66);
        graph.addVertex(6);

        List<Integer> vertices = graph.getVertices();
        int actualResult = vertices.size();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addEdge() {
        // Arrange
        graph.addVertex(15); // 0
        graph.addVertex(38); // 1
        graph.addVertex(123); // 2
        graph.addVertex(66); // 3
        graph.addVertex(6); // 4

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 23);
        graph.addEdge(0, 3, 90);

        graph.addEdge(1, 2, 55);
        graph.addEdge(1, 3, 2);

        graph.addEdge(2, 4, 7);
        graph.addEdge(2, 3, 76);

        graph.addEdge(3, 4, 8);

        List<Edge> edges = graph.getEdges();
        int actualResult = edges.size();
        int expectedResult = 8 * 2;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void largestVertexValue() {
        // Arrange
        graph.addVertex(15); // 0
        graph.addVertex(38); // 1
        graph.addVertex(123); // 2
        graph.addVertex(66); // 3
        graph.addVertex(6); // 4

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 23);
        graph.addEdge(0, 3, 90);

        graph.addEdge(1, 2, 55);
        graph.addEdge(1, 3, 2);

        graph.addEdge(2, 4, 7);
        graph.addEdge(2, 3, 76);

        graph.addEdge(3, 4, 8);

        int actualResult = graph.dfs(0);
        int expectedResult = 123;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void removeVertex() {
        // Arrange
        graph.addVertex(15); // 0
        graph.addVertex(38); // 1
        graph.addVertex(123); // 2
        graph.addVertex(66); // 3
        graph.addVertex(6); // 4

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 23);
        graph.addEdge(0, 3, 90);

        graph.addEdge(1, 2, 55);
        graph.addEdge(1, 3, 2);

        graph.addEdge(2, 4, 7);
        graph.addEdge(2, 3, 76);

        graph.addEdge(3, 4, 8);

        boolean vertexWasRemoved = graph.remove(15);
        assertTrue(vertexWasRemoved);

        int amountOfVertices = graph.getVertices().size();
        int expectedResult = 4;
        assertEquals(expectedResult, amountOfVertices);
    }

    @Test
    void removeEdge() {
        // Arrange
        graph.addVertex(15); // 0
        graph.addVertex(38); // 1
        graph.addVertex(123); // 2
        graph.addVertex(66); // 3
        graph.addVertex(6); // 4

        graph.addEdge(0, 1, 10);
        graph.addEdge(0, 4, 23);
        graph.addEdge(0, 3, 90);

        graph.addEdge(1, 2, 55);
        graph.addEdge(1, 3, 2);

        graph.addEdge(2, 4, 7);
        graph.addEdge(2, 3, 76);

        graph.addEdge(3, 4, 8);

        boolean wasEdgeRemoved = graph.remove(0, 1);
        assertTrue(wasEdgeRemoved);

        int amountOfEdges = graph.getEdges().size();
        int expectedResult = (8 * 2) - 2;
        assertEquals(expectedResult, amountOfEdges);
    }

}