package lektion11GraphAlgorithm;

import java.util.*;

public class GraphAlgorithms {

    /**
     * Returnerer en liste af grafens knuder fundet ved et dybdeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V baseVertex) {
        boolean[] visitedVertices = new boolean[graph.getVertices().size()];
        List<V> possiblePath = new ArrayList<>();
        return dfsRecursive(graph, baseVertex, possiblePath, visitedVertices);
    }

    private static <V> List<V> dfsRecursive (Graph<V> graph, V currentVertex, List<V> possiblePath, boolean[] visitedVertices) {
        int currentVertexIndex = graph.getIndex(currentVertex);
        if (visitedVertices[currentVertexIndex]) {
            possiblePath.remove(currentVertex);
            return possiblePath.reversed();
        }
        visitedVertices[currentVertexIndex] = true;

        for (V neighborVertex : graph.getNeighbors(currentVertex)) {
            int neighborIndex = graph.getIndex(neighborVertex);
            if (!visitedVertices[neighborIndex]) {
                possiblePath.add(neighborVertex);
                return dfsRecursive(graph, neighborVertex, possiblePath, visitedVertices);
            }
        }

        return possiblePath;
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V baseVertex) {
        List<V> vertices = new ArrayList<>();
        boolean[] visitedVertices = new boolean[graph.getVertices().size()];
        LinkedList<V> verticesQueue = new LinkedList<>();

        int baseVertexIndex = graph.getIndex(baseVertex);
        visitedVertices[baseVertexIndex] = true;
        verticesQueue.add(baseVertex);

        while (!verticesQueue.isEmpty()) {
            V nextVertexInQueue = verticesQueue.poll();
            vertices.add(nextVertexInQueue);
            for (V neighborVertex : graph.getNeighbors(nextVertexInQueue)) {
                int neighborVertexIndex = graph.getIndex(neighborVertex);
                if (!visitedVertices[neighborVertexIndex]) {
                    visitedVertices[neighborVertexIndex] = true;
                    verticesQueue.add(neighborVertex);
                }
            }
        }

        return vertices;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: Grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        if (graph.getVertices().isEmpty()) {
            return false;
        }

        List<V> vertices = graph.getVertices();
        for (V vertex : vertices) {
            int numberOfNeighbors = graph.getNeighbors(vertex).size();
            if (numberOfNeighbors != (vertices.size() - 1)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean dfsPath(Graph<V> graph, V baseVertex, V destination) {
        boolean[] visitedVertices = new boolean[graph.getVertices().size()];
        return dfsPath(graph, visitedVertices, baseVertex, destination);
    }

    public static <V> boolean dfsPath(Graph<V> graph, boolean[] visitedVertices, V currentVertex, V destination) {
        int currentVertexIndex = graph.getIndex(currentVertex);
        if (visitedVertices[currentVertexIndex]) {
            return false;
        } else if (currentVertex.equals(destination)) {
            return true;
        }
        visitedVertices[currentVertexIndex] = true;

        for (V neighborVertex : graph.getNeighbors(currentVertex)) {
            if (dfsPath(graph, visitedVertices, neighborVertex, destination)) {
                return true;
            }
        }

        return false;
    }


}