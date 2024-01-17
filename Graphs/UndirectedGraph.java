package Graphs;

import java.util.*;

class UndirectedGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public UndirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add an edge between two vertices
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For an undirected graph
    }

    // Find connected components using DFS
    public List<List<Integer>> findConnectedComponents() {
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> connectedComponents = new ArrayList<>();

        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                List<Integer> connectedComponent = new ArrayList<>();
                dfs(vertex, visited, connectedComponent);
                connectedComponents.add(connectedComponent);
            }
        }

        return connectedComponents;
    }

    private void dfs(int currentVertex, Set<Integer> visited, List<Integer> connectedComponent) {
        visited.add(currentVertex);
        connectedComponent.add(currentVertex);

        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, connectedComponent);
            }
        }
    }

    // Display the graph
    public void display() {
        System.out.println("Graph representation (Adjacency List):");
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            List<Integer> neighbors = adjacencyList.get(vertex);
            for (int neighbor : neighbors) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        UndirectedGraph graph = new UndirectedGraph();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Adding edges to create connected components
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 5);

        graph.display(); // Display the graph

        List<List<Integer>> connectedComponents = graph.findConnectedComponents();

        System.out.println("Connected Components:");
        for (List<Integer> component : connectedComponents) {
            System.out.println(component);
        }
    }
}
