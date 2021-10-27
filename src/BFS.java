import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BFS {
    public static void main(String[] args) throws FileNotFoundException {

        Graph graph;
        GraphConstruct graphConstruct = new GraphConstruct("C100.txt");
        if(graphConstruct.graphType.equals("D")) {
            graph = new Graph(true);
        } else {
            graph = new Graph(false);
        }
        int numberOfEdges = graphConstruct.numberOfEdges;
        List<Node> startList = new ArrayList<>();
        List<Node> endList = new ArrayList<>();
        for (int i = 0; i < numberOfEdges; i++) {
            startList.add(new Node(graphConstruct.startList.get(i), graphConstruct.startList.get(i).toString()));
            endList.add(new Node(graphConstruct.endList.get(i), graphConstruct.endList.get(i).toString()));
        }
        System.out.println("S: " + startList.size());
        System.out.println("E: " + endList.size());
        for (int i = 0; i < startList.size(); i++) {
            graph.addEdge(startList.get(i), endList.get(i));
//            System.out.println(startList.get(i).n + " " + endList.get(i).n);
        }
        System.out.println("BFS:");

        graph.breadthFirstSearch(startList.get(0));
    }
}
