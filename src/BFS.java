import java.io.FileNotFoundException;
import java.util.List;

public class BFS {
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
//        Node a = new Node(0, "0");
//        Node b = new Node(1, "1");
//        Node c = new Node(2, "2");
//        Node d = new Node(3, "3");
//        Node e = new Node(4, "4");
//
//        graph.addEdge(a, b);
//        graph.addEdge(b, c);
//        graph.addEdge(c, d);
//        graph.addEdge(d, e);
//        graph.addEdge(e, a);
        graph.breadthFirstSearch(firstNode);
    }
}
