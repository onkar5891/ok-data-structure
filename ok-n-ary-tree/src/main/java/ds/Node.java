package ds;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int data;
    public List<Node> children;

    public Node(int data) {
        this.data = data;
        children = new ArrayList<>();
    }
}
