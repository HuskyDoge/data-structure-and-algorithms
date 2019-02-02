import java.util.LinkedList;

/**
 * @author Jialun Li on 2019-02-01
 */
public class Graph {
    private int V;
    private LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
    }
}
