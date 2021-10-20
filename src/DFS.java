import java.io.FileNotFoundException;
import java.util.List;

public class DFS {
    public static void main(String[] args) throws FileNotFoundException {

        Graph graph;
        GraphConstruct graphConstruct = new GraphConstruct("dfs.txt");
        if(graphConstruct.graphType.equals("D")) {
            graph = new Graph(true);
        } else {
            graph = new Graph(false);
        }
        int numberOfVertices = graphConstruct.numberOfVertices;
        int numberOfEdges = graphConstruct.numberOfEdges;

        List<Integer> startList = graphConstruct.startList;
        List<Integer> endList = graphConstruct.endList;
        Node firstNode = new Node(startList.get(0), startList.get(0).toString());
        for (int i = 1; i < numberOfVertices; i++) {
            if(i == 1) {
                graph.addEdge(firstNode, new Node( endList.get(i), endList.get(i).toString()));
            } else {
                graph.addEdge(new Node(startList.get(i), startList.get(i).toString()), new Node(endList.get(i), endList.get(i).toString()));
            }
        }
        System.out.println("If we were to use our previous DFS method, we would get an incomplete traversal");
        graph.depthFirstSearch(firstNode);
        graph.resetNodesVisited(); // All nodes are marked as visited because of
    }
}