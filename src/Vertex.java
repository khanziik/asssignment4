public class Vertex {
    private int id;
    //constructor
    public Vertex (int id){
        this.id = id;
    }
    //getter
    public int getId(){
        return id;
    }
    //to string
    @Override
    public String toString(){
        return "Vertex " + id;
    }
}
// 0 1
1 7
2 5 7
