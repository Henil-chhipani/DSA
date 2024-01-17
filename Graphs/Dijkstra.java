package Graphs;

import java.util.*;

class Dijkstra {
    private Map<Integer, List<Edge>> adjacencyList;

    public Dijkstra() {
        adjacencyList = new HashMap<>();
    }

    // Edge class to represent weighted edges
    private static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    // Add a vertex to the graph
    public void addVertex(int vertex) {
        adjacencyList.put(vertex, new ArrayList<>());
    }

    // Add a weighted edge between two vertices
    public void addEdge(int source, int destination, int weight) {
        if (!adjacencyList.containsKey(source)) {
            addVertex(source);
        }
        if (!adjacencyList.containsKey(destination)) {
            addVertex(destination);
        }

        adjacencyList.get(source).add(new Edge(destination, weight));
        adjacencyList.get(destination).add(new Edge(source, weight)); // For an undirected graph
    }

    // Dijkstra's algorithm to find the shortest paths
    public Map<Integer, Integer> dijkstra(int startVertex) {
        Map<Integer, Integer> distance = new HashMap<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        for (int vertex : adjacencyList.keySet()) {
            distance.put(vertex, Integer.MAX_VALUE);
        }

        distance.put(startVertex, 0);
        minHeap.offer(new Node(startVertex, 0));

        while (!minHeap.isEmpty()) {
            Node currentNode = minHeap.poll();
            int currentVertex = currentNode.vertex;

            for (Edge neighbor : adjacencyList.get(currentVertex)) {
                int newDistance = distance.get(currentVertex) + neighbor.weight;

                if (newDistance < distance.get(neighbor.destination)) {
                    distance.put(neighbor.destination, newDistance);
                    minHeap.offer(new Node(neighbor.destination, newDistance));
                }
            }
        }

        return distance;
    }

    private static class Node {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }

    // Display the graph
    public void display() {
        System.out.println("Graph representation (Adjacency List):");
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            List<Edge> edges = adjacencyList.get(vertex);
            for (Edge edge : edges) {
                System.out.print("(" + edge.destination + ", " + edge.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Dijkstra graph = new Dijkstra();

        // Adding vertices
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        // Adding weighted edges
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 4);
        graph.addEdge(2, 3, 2);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 7);
        graph.addEdge(4, 5, 3);

        graph.display(); // Display the graph

        int startVertex = 1;
        Map<Integer, Integer> shortestPaths = graph.dijkstra(startVertex);

        System.out.println("Shortest paths from vertex " + startVertex + ":");
        for (int vertex : shortestPaths.keySet()) {
            System.out.println("To vertex " + vertex + ": " + shortestPaths.get(vertex));
        }
    }
}
