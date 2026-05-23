public class Experiment {
    //run traversals
    public void runTraversals(Graph g){
        long startBFS = System.nanoTime();
        g.bfs(0);
        long endBFS = System.nanoTime();
        long bfsTime = endBFS - startBFS;
        long startDFS = System.nanoTime();
        g.dfs(0);
        long endDFS = System.nanoTime();
        long dfsTime = endDFS - startDFS;

        System.out.println("BFS Time: " + bfsTime + " ns");
        System.out.println("DFS Time: " + dfsTime + " ns");
    }
    //create graph
    public Graph createGraph(int size){
        Graph g = new Graph();
        //add verticies
        for(int i = 0; i < size; i++){
            g.addVertex(new Vertex(i));
        }
        //add edges
        for (int i = 0; i< size - 1; i++){
            g.addEdge(i, i + 1, (i % 5) + 1);
        }
        return g;
    }
    //multiple tests
    public void runMultipleTests(){
        int[] sizes = {10, 30, 100};
        for(int size : sizes){
            System.out.println("\nGraph size: " + size);
            Graph g = createGraph(size);
            if(size == 10){
                g.printGraph();
            }
            runTraversals(g);
        }
    }
    //print
    public void printResults(){
        System.out.println("Experiments completed");
    }
}
