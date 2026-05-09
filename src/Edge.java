public class Edge {
    private Vertex source;
    private Vertex destination;
    //constructor
    public Edge(Vertex source, Vertex destination){
        this.source = source;
        this.destination = destination;
    }
    //getters
    public Vertex getSource() {
        return source;
    }
    public Vertex getDestination(){
        return destination;
    }
    //toString
    @Override
    public String toString(){
        return source.getId() + destination.getId();

    }
}
