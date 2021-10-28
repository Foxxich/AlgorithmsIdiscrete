import java.io.FileNotFoundException;
import java.util.*;
import java.util.LinkedList;
//strongly connected components
class GCC
{
    private int V;
    private LinkedList<Integer> adj[];

    GCC(int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList<>();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w)  { adj[v].add(w); }

    // A recursive function to print DFS starting from v
    void DFSUtil(int v, boolean[] visited)
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        int n;

        // Recur for all the vertices adjacent to this vertex
        for (Integer integer : adj[v]) {
            n = integer;
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // Function that returns reverse of this graph
    GCC getTranspose()
    {
        GCC g = new GCC(V);
        for (int v = 0; v < V; v++)
        {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> i =adj[v].listIterator();
            while(i.hasNext())
                g.adj[i.next()].add(v);
        }
        return g;
    }

    void fillOrder(int v, boolean visited[], Stack<Integer> stack)
    {
        // Mark the current node as visited and print it
        visited[v] = true;

        // Recur for all the vertices adjacent to this vertex
        for (int n : adj[v]) {
            if (!visited[n])
                fillOrder(n, visited, stack);
        }

        stack.push(v);
    }

    void printSCCs()
    {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (!visited[i])
                fillOrder(i, visited, stack);

        GCC transpose = getTranspose();
        // Mark all the vertices as not visited (For second DFS)
        for (int i = 0; i < V; i++)
            visited[i] = false;

        while (!stack.empty())
        {
            // Pop a vertex from stack
            int v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if (!visited[v])
            {
                transpose.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        GraphConstruct graphConstruct = new GraphConstruct("C1000.txt");
        if(graphConstruct.graphType.equals("D")) {

            int numberOfVertices = graphConstruct.numberOfVertices;
            int numberOfEdges = graphConstruct.numberOfEdges;

            List<Integer> startList = graphConstruct.startList;
            List<Integer> endList = graphConstruct.endList;
            GCC g = new GCC(numberOfVertices);
            for (int i = 0; i < numberOfEdges; i++) {
                g.addEdge(startList.get(i), endList.get(i));
            }
            System.out.println("Following are strongly connected components in given graph ");
            g.printSCCs();
        } else {
            System.out.println("Expected directed graph!");
        }
    }
}

