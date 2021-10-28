import java.util.*;

public class Graph {
    // Each node maps to a list of all his neighbors
    private HashMap<Node, LinkedList<Node>> adjacencyMap;
    private List<Node> nodes = new ArrayList<>();
    private boolean directed;

    public Graph(boolean directed) {
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }

    public void addEdgeHelper(Node a, Node b) {
        LinkedList<Node> tmp = adjacencyMap.get(a);

        if (tmp != null) {
            tmp.remove(b);
        }
        else tmp = new LinkedList<>();
        tmp.add(b);
        adjacencyMap.put(a, tmp);
    }

    public void addEdge(Node sourceToAdd, Node destinationToAdd) {

        Node source = obtainNode(sourceToAdd);
        Node destination =  obtainNode(destinationToAdd);

        // We make sure that every used node shows up in our .keySet()
        if (!adjacencyMap.containsKey(source))
            adjacencyMap.put(source, null);

        if (!adjacencyMap.containsKey(destination))
            adjacencyMap.put(destination, null);

        addEdgeHelper(source, destination);

        // If a graph is undirected, we want to add an edge from destination to source as well
        if (!directed) {
            addEdgeHelper(destination, source);
        }
    }

    private Node obtainNode(Node node) {
        int indexOfNode = nodes.indexOf(node);
        if(indexOfNode != -1) {
            return nodes.get(indexOfNode);
        } else {
            nodes.add(node);
            return node;
        }
    }

    public void depthFirstSearch(Node node) {
        node.visit();
        System.out.print(node.name + " ");

        LinkedList<Node> allNeighbors = adjacencyMap.get(node);
        if (allNeighbors == null)
            return;

        for (Node neighbor : allNeighbors) {
            if (!neighbor.visited)
                depthFirstSearch(neighbor);
        }
    }

    void breadthFirstSearch(Node node) {

        // Just so we handle receiving an uninitialized Node, otherwise an
        // exception will be thrown when we try to add it to queue
        if (node == null)
            return;

        // Creating the queue, and adding the first node (step 1)
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentFirst = queue.removeFirst();

            if (currentFirst.visited)
                continue;

            // Mark the node as visited
            currentFirst.visit();
            System.out.print(currentFirst.name + " ");

            LinkedList<Node> allNeighbors = adjacencyMap.get(currentFirst);

            if (allNeighbors == null)
                continue;

            for (Node neighbor : allNeighbors) {
                // We only add unvisited neighbors
                if (!neighbor.visited) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
