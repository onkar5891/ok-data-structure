package ds.binarytree;

import static java.util.Objects.isNull;

public class Node {
    public int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return isNull(left) && isNull(right);
    }
}
