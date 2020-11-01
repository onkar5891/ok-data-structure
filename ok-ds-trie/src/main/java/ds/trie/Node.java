package ds.trie;

public class Node {
    private static final int ALPHABET_SIZE = 26;

    public Node[] nodes = new Node[ALPHABET_SIZE];
    public boolean isEndOfWord;
}
