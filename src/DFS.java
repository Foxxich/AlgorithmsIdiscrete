import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class DFS {
    public static void main(String[] args) throws FileNotFoundException {

        Graph graph;
        GraphConstruct graphConstruct = new GraphConstruct("C100.txt");
        if(graphConstruct.graphType.equals("D")) {
            graph = new Graph(true);
        } else {
            graph = new Graph(false);
        }
        int numberOfVertices = graphConstruct.numberOfVertices;
        int numberOfEdges = graphConstruct.numberOfEdges;

        List<Node> startList = new ArrayList<>();
        List<Node> endList = new ArrayList<>();
        List<Node> nodeList = new ArrayList<>();
//        for (int i = 0; i < numberOfEdges; i++) {
//            nodeList.add(new Node(i, Integer.toString(i)));
//        }
        for (int i = 0; i < numberOfEdges; i++) {
            startList.add(new Node(graphConstruct.startList.get(i), graphConstruct.startList.get(i).toString()));
            endList.add(new Node(graphConstruct.endList.get(i), graphConstruct.endList.get(i).toString()));
        }
        System.out.println("S: " + startList.size());
        System.out.println("E: " + endList.size());
        for (int i = 0; i < startList.size(); i++) {
            graph.addEdge(startList.get(i), endList.get(i));
            System.out.println(startList.get(i).n + " " + endList.get(i).n);
        }
//        Node a = new Node(0, "0");
//        Node b = new Node(1, "1");
//        Node c = new Node(2, "2");
//        Node d = new Node(3, "3");
//        Node e = new Node(4, "4");
//        graph.addEdge(a,b);
//        graph.addEdge(b,c);
//        graph.addEdge(c,d);
//        graph.addEdge(d,e);
//        graph.addEdge(e,a);
        System.out.println("DFS:");
        graph.depthFirstSearch(startList.get(0));
    }
}

//for (int i = 1; i < numberOfEdges; i++) {
//        Node node1 = new Node(startList.get(i), startList.get(i).toString());
//        if(i == 1) {
//        graph.addEdge(firstNode, node1);
//        System.out.println(firstNode.n);
//        System.out.println(node1.n+"\n");
//        Node node2 = new Node(endList.get(i), endList.get(i).toString());
//        graph.addEdge(node1, node2);
//        System.out.println(node1.n);
//        System.out.println(node2.n+"\n");
//        } else {
//        if(i < numberOfEdges - 1) {
//        Node node2 = new Node(endList.get(i), endList.get(i).toString());
//        graph.addEdge(node1, node2);
//        System.out.println(node1.n);
//        System.out.println(node2.n + "\n");
//        } else {
//        graph.addEdge(node1, firstNode);
//        System.out.println(node1.n);
//        System.out.println(firstNode.n + "\n");
//        }
//        }
//        }