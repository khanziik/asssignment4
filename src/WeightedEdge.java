public class WeightedEdge {
    public class WeightedEdge {

        int destination;
        int weight;

        public WeightedEdge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public int getDestination() {
            return destination;
        }

        public int getWeight() {
            return weight;
        }

        @Override
        public String toString() {
            return destination + "(" + weight + ")";
        }
    }}
