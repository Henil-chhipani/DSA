package Graphs;

import java.util.*;

class BipartiteGraph {
    private Map<Integer, List<Integer>> adjacencyList;

    public BipartiteGraph() {
        adjacencyList = new HashMap<>();
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add an undirected edge between two vertices
    public void addEdge(int source, int destination) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    // Check if the graph is bipartite using BFS
    public boolean isBipartite() {
        if (adjacencyList.isEmpty()) {
            return true; // An empty graph is considered bipartite
        }

        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> color = new HashMap<>();

        for (int vertex : adjacencyList.keySet()) {
            if (!visited.contains(vertex)) {
                if (!isBipartiteBFS(vertex, visited, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isBipartiteBFS(int startVertex, Set<Integer> visited, Map<Integer, Integer> color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);
        visited.add(startVertex);
        color.put(startVertex, 0); // Color the starting vertex with color 0

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            int currentColor = color.get(currentVertex);

            for (int neighbor : adjacencyList.get(currentVertex)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    color.put(neighbor, 1 - currentColor); // Assign the opposite color
                    queue.offer(neighbor);
                } else if (color.get(neighbor) == currentColor) {
                    return false; // Detected an odd-length cycle, graph is not bipartite
                }
            }
        }

        return true;
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
        BipartiteGraph graph = new BipartiteGraph();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        // Adding undirected edges to create a bipartite graph
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        graph.display(); // Display the graph

        boolean isBipartite = graph.isBipartite();

        if (isBipartite) {
            System.out.println("The graph is bipartite.");
        } else {
            System.out.println("The graph is not bipartite.");
        }
    }
}
