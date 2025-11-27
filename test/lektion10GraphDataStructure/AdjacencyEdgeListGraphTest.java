package lektion10GraphDataStructure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AdjacencyEdgeListGraphTest {
    private AdjacencyEdgeListGraph<Integer> graph;

    @BeforeEach
    void setUp() {
        graph = new AdjacencyEdgeListGraph<>();

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
    }

    @Test
    void getSize() {
        int actualResult = graph.getSize();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getNumEdges() {
        int actualResult = graph.getNumEdges();
        int expectedResult = 8;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getVertices() {
        int actualResult = graph.getVertices().size();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getEdges() {
        int actualResult = graph.getEdges().size();
        int expectedResult = 8 * 2;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getVertex() {
        int actualResult = graph.getVertices().size();
        int expectedResult = 5;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getIndex() {
        int actualResult = graph.getIndex(15);
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);

        actualResult = graph.getIndex(38);
        expectedResult = 1;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getNeighbors() {
        int actualResult = graph.getNeighbors(15).size();
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);

        actualResult = graph.getNeighbors(66).size();
        expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getNeighborsIndex() {
        int actualResult = graph.getNeighborsIndex(15).size();
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);

        actualResult = graph.getNeighborsIndex(66).size();
        expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void getIncidentEdges() {
        int actualResult = graph.getIncidentEdges(38).size();
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);

    }

    @Test
    void getDegree() {
        int actualResult = graph.getDegree(38);
        int expectedResult = 3;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void printEdges() {
        graph.printEdges();
    }

    @Test
    void clear() {
        graph.clear();

        int actualResult = graph.getVertices().size();
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);

        actualResult = graph.getEdges().size();
        expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void addVertex() {
        graph.clear();

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
        graph.clear();
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
    void removeVertex() {
        boolean wasVertexRemoved = graph.remove(15);
        assertTrue(wasVertexRemoved);

        int actualAmountOfVertices = graph.getSize();
        int expectedAmountOfVertices = 4;
        assertEquals(expectedAmountOfVertices, actualAmountOfVertices);

        int actualAmountOfEdges = graph.getNumEdges();
        int expectedAmountOfEdges = 8 - 3;
        assertEquals(expectedAmountOfEdges, actualAmountOfEdges);
    }

    @Test
    void removeEdge() {
        boolean wasVertexRemoved = graph.remove(0,1);
        assertTrue(wasVertexRemoved);

        int actualAmountOfVertices = graph.getSize();
        int expectedAmountOfVertices = 5;
        assertEquals(expectedAmountOfVertices, actualAmountOfVertices);

        int actualAmountOfEdges = graph.getNumEdges();
        int expectedAmountOfEdges = 8 - 1;
        assertEquals(expectedAmountOfEdges, actualAmountOfEdges);
    }

}