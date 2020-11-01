package ds.trie;

public class Trie {
    private final Node root = new Node();

    public void insert(String key) {
        Node node = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.nodes[index] == null) {
                node.nodes[index] = new Node();
            }
            // Go to the next level
            node = node.nodes[index];
        }

        // Mark last node as leaf
        node.isEndOfWord = true;
    }

    public boolean search(String key) {
        Node node = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (node.nodes[index] == null) {
                return false;
            }
            node = node.nodes[index];
        }

        return node.isEndOfWord;
    }
}
