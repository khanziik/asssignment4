public class Main {

    public static void main(String[] args) {

        //small weighted graph for demonstration
        Graph g = new Graph();

        for (int i = 0; i < 5; i++) {
            g.addVertex(new Vertex(i));
        }

        g.addEdge(0, 1, 4);
        g.addEdge(0, 2, 2);
        g.addEdge(1, 3, 1);
        g.addEdge(2, 3, 5);
        g.addEdge(3, 4, 3);

        g.printGraph();

        g.bfs(0);

        g.dfs(0);

        g.dijkstra(0);

        // experiments
        System.out.println("\nPERFORMANCE TESTS");

        Experiment experiment = new Experiment();

        experiment.runMultipleTests();

        experiment.printResults();
    }
}