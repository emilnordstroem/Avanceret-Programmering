package lektion10GraphDataStructure;

import java.util.*;

public class AdjacencyEdgeListGraph<V> implements Graph<V> {
    Map<V, List<Edge>> vertices = new HashMap<>();
    List<V> orderedVertices = new ArrayList<>();

    public AdjacencyEdgeListGraph() {
    }

    @Override
    public int getSize() {
        return vertices.size();
    }

    @Override
    public int getNumEdges() {
        int edgeCounter = 0;

        for (List<Edge> edgeList : vertices.values()) {
            edgeCounter += edgeList.size();
        }

        return edgeCounter / 2;
    }

    @Override
    public List<V> getVertices() {
        return new ArrayList<>(orderedVertices);
    }

    @Override
    public List<Edge> getEdges() {
        List<Edge> edges = new ArrayList<>();

        for (List<Edge> edgeList : vertices.values()) {
            edges.addAll(edgeList);
        }

        return edges;
    }

    @Override
    public V getVertex(int index) {
        return orderedVertices.get(index);
    }

    @Override
    public int getIndex(V v) {
        return orderedVertices.indexOf(v);
    }

    @Override
    public List<V> getNeighbors(V v) {
        List<V> neighborVertices = new ArrayList<>();
        List<Edge> edges = vertices.get(v);
        for (Edge edge : edges) {
            V adjacentVertex = orderedVertices.get(edge.v);
            neighborVertices.add(adjacentVertex);
        }
        return neighborVertices;
    }

    @Override
    public List<Integer> getNeighborsIndex(V v) {
        List<Integer> neighborVertexIndexes = new ArrayList<>();
        List<Edge> edges = vertices.get(v);
        for (Edge edge : edges) {
            neighborVertexIndexes.add(edge.v);
        }
        return neighborVertexIndexes;
    }

    @Override
    public List<Edge> getIncidentEdges(V v) {
        return new ArrayList<>(vertices.get(v));
    }

    @Override
    public int getDegree(V v) {
        return getIncidentEdges(v).size();
    }

    @Override
    public void printEdges() {
        vertices.forEach((vertex, edges) -> {
            edges.forEach(edge -> System.out.println(edge.toString()));
        });
    }

    @Override
    public void clear() {
        vertices = new HashMap<>();
        orderedVertices = new ArrayList<>();
    }

    @Override
    public boolean addVertex(V vertex) {
        if (!vertices.containsKey(vertex)) {
            vertices.put(vertex, new ArrayList<>());
            orderedVertices.add(vertex);
        }
        return false;
    }

    private boolean addEdge(Edge edge) {
        if (edge.u < 0 || edge.u > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + edge.u);

        if (edge.v < 0 || edge.v > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + edge.v);

        V sourceVertex = orderedVertices.get(edge.u);
        List<Edge> existingEdges = vertices.get(sourceVertex);

        if (!existingEdges.contains(edge)) {
            vertices.get(sourceVertex).add(edge);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean addEdge(int u, int v, int e) {
        return addEdge(new Edge(u, v, e)) && addEdge(new Edge(v, u, e));
    }

    @Override
    public boolean addEdge(int u, int v) {
        return addEdge(new Edge(u, v, 0)) && addEdge(new Edge(v, u, 0));
    }

    @Override
    public boolean remove(V v) {
        if (!vertices.containsKey(v)) {
            return false;
        }

        if (getDegree(v) != 0) {
            List<Edge> incidentEdges = getIncidentEdges(v);
            incidentEdges.forEach(edge -> remove(edge.u, edge.v));
        }

        reindexEdges(getIndex(v));
        vertices.remove(v);
        orderedVertices.remove(v);
        return true;
    }

    @Override
    public boolean remove(int u, int v) {
        boolean edgesWasRemoved = false;

        for (List<Edge> edges : vertices.values()) {

            Iterator<Edge> edgeIterator = edges.iterator();

            while (edgeIterator.hasNext()) {
                Edge currentEdge = edgeIterator.next();
                if ((currentEdge.u == u && currentEdge.v == v) || (currentEdge.u == v && currentEdge.v == u)) {
                    edgeIterator.remove();
                    edgesWasRemoved = true;
                }
            }

        }
        return edgesWasRemoved;
    }

    private void reindexEdges (int baseIndex) {
        vertices.forEach((vertex, edges) -> {
            edges.forEach(edge -> {
                if (edge.u > baseIndex) {
                    edge.u--;
                }
                if (edge.v > baseIndex) {
                    edge.v--;
                }
            });
        });
    }

}
