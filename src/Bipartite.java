import java.io.FileNotFoundException;
import java.util.*;
import java.lang.*;

class Bipartite
{

    // Function to store the connected nodes
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    // Function to check whether a
// graph is bipartite or not
    static boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int v, boolean[] visited, int[] color) {
        for(int u : adj.get(v))
        {

            // If vertex u is not explored before
            if (!visited[u])
            {

                // Mark present vertic as visited
                visited[u] = true;

                // Mark its color opposite to its parent
                color[u] = 1 - color[v];

                // If the subtree rooted at vertex
                // v is not bipartite
                if (!isBipartite(adj, u, visited, color))
                    return false;
            }

            // If two adjacent are colored with
            // same color then the graph is
            // not bipartite
            else if (color[u] == color[v])
                return false;
        }
        return true;
    }

    // Driver Code
    public static void main(String[] args) throws FileNotFoundException {
        boolean flag = false;
        GraphConstruct graphConstruct = new GraphConstruct("bipartite.txt");

        int numberOfVertices = graphConstruct.numberOfVertices; //7

        // To maintain the adjacency list of graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(numberOfVertices + 1);

        // Initialize all the vertex
        for(int i = 0; i <= numberOfVertices; i++)
        {
            adj.add(new ArrayList<Integer>());
        }

        // To keep a check on whether
        // a node is discovered or not
        boolean[] visited = new boolean[numberOfVertices + 1];

        // To color the vertices
        // of graph with 2 color
        int[] color = new int[numberOfVertices + 1];

        // The value '-1' of colorArr[i] is
        // used to indicate that no color is
        // assigned to vertex 'i'. The value
        // 1 is used to indicate first color
        // is assigned and value 0 indicates
        // second color is assigned.
        Arrays.fill(color, -1);

        List<Integer> startList = graphConstruct.startList;
        List<Integer> endList = graphConstruct.endList;
        // Adding edges to the graph
        for (int i = 0; i < numberOfVertices; i++) {
            addEdge(adj, startList.get(i), endList.get(i));
        }

        // Marking the source node as visited
        visited[1] = true;

        // Marking the source node with a color
        color[1] = 0;

        // Function to check if the graph
        // is Bipartite or not
        if (isBipartite(adj, 1, visited, color))
        {
            System.out.println("Graph is Bipartite");
            printSets(color);
        }
        else
        {
            System.out.println("Graph is not Bipartite");
        }
        if(flag) {
            printGraph(adj, color);
        }
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj, int[] color) {
        for (int i = 0; i < color.length; i++) {
            System.out.println(color[i] + " " + adj.get(i));
        }
    }

    private static void printSets(int[] color) {
        List<Integer> v0 = new LinkedList<>();
        List<Integer> v1 = new LinkedList<>();
        for (int i = 0; i < color.length; i++) {
            if(color[i] == 0) {
                v0.add(i);
            } else if(color[i] == 1) {
                v1.add(i);
            }
        }
        System.out.println("V0 :" + v0.toString());
        System.out.println("V1 :" + v1.toString());
    }
}