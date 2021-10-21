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
        for (int i = 1; i < numberOfEdges; i++) {
            Node node1 = new Node(startList.get(i), startList.get(i).toString());
            if(i == 1) {
                graph.addEdge(firstNode, node1);
                System.out.println(firstNode.n);
                System.out.println(node1.n+"\n");
                Node node2 = new Node(endList.get(i), endList.get(i).toString());
                graph.addEdge(node1, node2);
                System.out.println(node1.n);
                System.out.println(node2.n+"\n");
            } else {
                if(i < numberOfEdges - 1) {
                    Node node2 = new Node(endList.get(i), endList.get(i).toString());
                    graph.addEdge(node1, node2);
                    System.out.println(node1.n);
                    System.out.println(node2.n + "\n");
                } else {
                    graph.addEdge(node1, firstNode);
                    System.out.println(node1.n);
                    System.out.println(firstNode.n + "\n");
                }
            }
        }
        System.out.println("If we were to use our previous DFS method, we would get an incomplete traversal");
        graph.depthFirstSearch(firstNode);
        graph.resetNodesVisited(); // All nodes are marked as visited because of
    }
}