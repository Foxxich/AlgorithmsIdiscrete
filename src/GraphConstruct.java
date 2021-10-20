import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphConstruct {

    String sourceName;
    String graphType;
    int numberOfVertices;
    int numberOfEdges;

    List<Integer> startList = new ArrayList<>(numberOfEdges);
    List<Integer> endList = new ArrayList<>(numberOfEdges);

    public GraphConstruct(String sourceName) throws FileNotFoundException {
        this.sourceName = sourceName;
        loadData();
    }

    public void loadData () throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("C:\\Users\\Vadym\\Documents\\Lista1\\src\\"+sourceName));
        graphType = String.valueOf(scanner.next());
        numberOfVertices = Integer.parseInt(String.valueOf(scanner.nextInt()));
        numberOfEdges = Integer.parseInt(String.valueOf(scanner.nextInt()));

        startList = new ArrayList<>(numberOfEdges);
        endList = new ArrayList<>(numberOfEdges);

        for (int i = 0; i <= numberOfEdges; i++) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            int counter = 0;
            while (lineScanner.hasNextInt()) {
                if (counter == 0) {
                    startList.add(lineScanner.nextInt());
                    counter++;
                } else {
                    endList.add(lineScanner.nextInt());
                    counter--;
                }
            }
        }
    }
}
