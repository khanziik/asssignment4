import java.util.*;

public class Graph {

    // adjacency list
    private Map<Integer, List<WeightedEdge>> adjacencyList;

    // constructor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // add weighted edge
    public void addEdge(int from, int to, int weight) {

        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());

        adjacencyList.get(from).add(new WeightedEdge(to, weight));
        adjacencyList.get(to).add(new WeightedEdge(from, weight));
    }

    // print graph
    public void printGraph() {

        System.out.println("\n--- WEIGHTED GRAPH ---");

        for (int vertex : adjacencyList.keySet()) {

            System.out.print(vertex + " -> ");

            for (WeightedEdge edge : adjacencyList.get(vertex)) {

                System.out.print(edge + " ");
            }

            System.out.println();
        }
    }

    // BFS
    public void bfs(int start) {

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");

            for (WeightedEdge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination();

                if (!visited.contains(neighbor)) {

                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    // DFS
    public void dfs(int start) {

        Set<Integer> visited = new HashSet<>();

        System.out.print("DFS: ");

        dfsHelper(start, visited);

        System.out.println();
    }

    // DFS helper method
    private void dfsHelper(int current, Set<Integer> visited) {

        visited.add(current);

        System.out.print(current + " ");

        for (WeightedEdge edge : adjacencyList.get(current)) {

            int neighbor = edge.getDestination();

            if (!visited.contains(neighbor)) {

                dfsHelper(neighbor, visited);
            }
        }
    }

    // Dijkstra algorithm
    public void dijkstra(int start) {

        int size = adjacencyList.size();

        int[] distance = new int[size];
        boolean[] visited = new boolean[size];

        // set all distances to infinity
        Arrays.fill(distance, Integer.MAX_VALUE);

        // start vertex distance = 0
        distance[start] = 0;

        for (int i = 0; i < size; i++) {

            int current = -1;
            int minDistance = Integer.MAX_VALUE;

            // find minimum distance vertex
            for (int j = 0; j < size; j++) {

                if (!visited[j] && distance[j] < minDistance) {

                    minDistance = distance[j];
                    current = j;
                }
            }

            // stop if unreachable
            if (current == -1) {
                break;
            }

            visited[current] = true;

            // update neighbor distances
            for (WeightedEdge edge : adjacencyList.get(current)) {

                int neighbor = edge.getDestination();
                int weight = edge.getWeight();

                if (!visited[neighbor]
                        && distance[current] + weight < distance[neighbor]) {

                    distance[neighbor] = distance[current] + weight;
                }
            }
        }

        // print results
        System.out.println("\nShortest distances from vertex " + start + ":");

        for (int i = 0; i < distance.length; i++) {

            System.out.println(start + " -> " + i + " = " + distance[i]);
        }
    }
}