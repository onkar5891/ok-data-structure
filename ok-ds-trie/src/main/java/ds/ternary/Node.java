package ds.ternary;

public class Node {
    public char data;
    public boolean isEndOfWord;
    public Node left;
    public Node eq;
    public Node right;

    public Node(char data) {
        this.data = data;
    }
}
