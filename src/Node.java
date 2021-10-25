import java.util.Objects;

public class Node {
    int n;
    String name;
    boolean visited; // New attribute

    Node(int n, String name) {
        this.n = n;
        this.name = name;
        visited = false;
    }

    // Two new methods we'll need in our traversal algorithms
    void visit() {
        visited = true;
    }

    void unvisit() {
        visited = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}