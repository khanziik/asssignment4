import java.sql.Array;
import java.util.*;
public class Graph {
    //adjacency list
    private Map<Integer, List<WeightedEdge>> adjacencyList;

    //constructor
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    //add vertex
    public void addVertex(Vertex v) {
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    // UPDATED add edge
    public void addEdge(int from, int to, int weight) {

        adjacencyList.putIfAbsent(from, new ArrayList<>());
        adjacencyList.putIfAbsent(to, new ArrayList<>());

        adjacencyList.get(from).add(new WeightedEdge(to, weight));
        adjacencyList.get(to).add(new WeightedEdge(from, weight));
    }

    //print graph
    public void printGraph() {
        System.out.println("GRAPH STRUCTURE: ");
        for (int vertex : adjacencyList.keySet()) {
            System.out.print(vertex + " -> ");
            for (int neighbor : adjacencyList.get(vertex)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    //bfs
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);
        System.out.print("BFS: ");

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");
            for(int neighbor : adjacencyList.get(current)){
                if (!visited.contains(neighbor)){
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
    //DFS
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }
    //helper methode
    private void dfsHelper(int current, Set<Integer> visited ){
        visited.add(current);
        System.out.print(current + " ");
                for(int neighbor : adjacencyList.get(current)){
                    if (!visited.contains(neighbor)){
                        dfsHelper(neighbor, visited);
                    }
                }
    }
}