package ds.trie;

public class Trie {
    private final Node root = new Node();

    public void insert(String key) {
        Node trie = root;

        for (int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if (trie.nodes[index] == null) {
                trie.nodes[index] = new Node();
            }
            // Go to the next level
            trie = trie.nodes[index];
        }

        // Mark last trie node as leaf
        trie.isEndOfWord = true;
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
