import java.util.Arrays;
import java.util.stream.IntStream;

public class AdjacencyMatrixGraph implements Graph{

    int no_nodes;
    int graph[][];

    public AdjacencyMatrixGraph(int no_nodes) {
        this.no_nodes = no_nodes;

        graph = new int [no_nodes][no_nodes];
    }


    @Override
    public String toString() {
        return Arrays.deepToString(graph).replace("], ", "]\n").replace("[[", "[").replace("]]", "]");
    }

    @Override
    public void addEdge(int n1, int n2) {
        graph[n1][n2] = graph[n2][n1] = 1;
    }

    @Override
    public void removeEdge(int n1, int n2) {

        graph[n1][n2] = graph[n2][n1] = 0;
    }

    @Override
    public boolean isConnected(int src, int des) {
        boolean visited[] = new boolean[no_nodes];
        return (!inbound(src) || !inbound(des)) ? false : connected(src,des, visited);
    }

    public boolean hasEdge(int src, int des){
        return (!inbound(src) || !inbound(des)) ? false : (graph[src][des] == 1  || graph[des][src] == 1);
    }

    private boolean inbound(int n){
        return (n >= 0 && n <= no_nodes);
    }


    private boolean connected(int source, int destination, boolean visited[]){

        if(hasEdge(source, destination))
            return true;

        for(int node = 0; node < no_nodes; node++) {
            if (hasEdge(source, node) && !visited[node]) {
                visited[node] = true;
                if (connected(node, destination, visited))
                    return true;
            }
        }

        return false;

    }

    public boolean isConnetedGraph(){
        return dfs(0, new boolean[no_nodes]) == no_nodes;
    }

    public int no_neighbors(int src){
        return IntStream.of(Arrays.copyOfRange(graph[src], 0, no_nodes)).sum();
    }

    private int dfs(int src, boolean visited[]) {

        if (!visited[src]) {

            visited[src] = true;
            int sum = 0;

            for (int i = 0; i < no_nodes; i++)
                sum += (hasEdge(src, i)) ? dfs(i, visited) : 0;

            return 1 + sum;
        }

        return 0;
    }

   /* public int shortestPath(int src, int des, int distance, boolean visited[], int[] distance_vector){
        if(!visited[src]){

            distance_vector = new int[no_nodes];

            for(int i = 0; i < no_nodes; i++)
            distance_vector[i] = hasEdge(src, des) ? graph[src]
        }

        return 0;
    }*/

    public int[] union(int n1){
       return  graph[n1];//Arrays.stream(graph[n1]).map(n -> n).toArray();
    }

    int[] getNeighborsDistanceVector(int src){
        return Arrays.copyOfRange(graph[src], 0, no_nodes);
    }

    public int[] addRows(int a, int b){
        return IntStream.range(0, no_nodes).map(i -> graph[a][i] & graph[b][i]).toArray();
    }
}
