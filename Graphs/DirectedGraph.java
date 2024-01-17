package Graphs;

import java.util.*;

class DirectedGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public DirectedGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add a directed edge between two vertices
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        adjacencyList.get(source).add(destination);
    }

    // Detect cycle using DFS
    public boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> currentlyVisiting = new HashSet<>();

        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex) && dfs(vertex, visited, currentlyVisiting)) {
                return true;
            }
        }

        return false;
    }

    private boolean dfs(int currentVertex, Set<Integer> visited, Set<Integer> currentlyVisiting) {
        visited.add(currentVertex);
        currentlyVisiting.add(currentVertex);

        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (!visited.contains(neighbor)) {
                if (dfs(neighbor, visited, currentlyVisiting)) {
                    return true;
                }
            } else if (currentlyVisiting.contains(neighbor)) {
                // A back edge is found, indicating a cycle
                return true;
            }
        }

        currentlyVisiting.remove(currentVertex);
        return false;
    }

    // Display the graph
    public void display() {
        System.out.println("Directed Graph representation (Adjacency List):");
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
        DirectedGraph graph = new DirectedGraph();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Adding directed edges to create a cycle
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 1);

        graph.display(); // Display the directed graph

        boolean hasCycle = graph.hasCycle();

        if (hasCycle) {
            System.out.println("The directed graph has a cycle.");
        } else {
            System.out.println("The directed graph does not have a cycle.");
        }
    }
}
