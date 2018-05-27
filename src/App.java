import java.util.Arrays;

public class App {

    // biggest computable number : 22513
    public static void main(String[] args){
        Graph g = new AdjacencyMatrixGraph(8);

        g.addEdge(1,7);
        g.addEdge(1,3);
        g.addEdge(3,4);
        g.addEdge(4,2);
        g.addEdge(2,6);
        g.addEdge(6,5);
        g.addEdge(5,0);
        System.out.println(g + "\n");

        System.out.println(Arrays.toString(((AdjacencyMatrixGraph) g).addRows(2,3)));
        //g.removeEdge(6,5);
        //System.out.println(((AdjacencyMatrixGraph) g).isConnetedGraph());
        //System.out.println(((AdjacencyMatrixGraph) g).no_neighbors(6));

    }
}
