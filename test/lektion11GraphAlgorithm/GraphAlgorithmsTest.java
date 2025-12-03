package lektion11GraphAlgorithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraphAlgorithmsTest {
    private Graph<Integer> graph = new EdgeListGraph<>();

    @BeforeEach
    void setUp() {
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
    void dfs() {
        List<Integer> paths = GraphAlgorithms.dfs(graph, 15);
        paths.forEach(node -> System.out.println(node));
    }

    @Test
    void bfs() {
        List<Integer> paths = GraphAlgorithms.bfs(graph, 15);
        paths.forEach(node -> System.out.println(node));
    }

    @Test
    void connected() {
    }

    @Test
    void isPath() {
    }
}