package ds.ternary;

public class TernarySearchTree {
    public Node insert(Node root, String key) {
        if (root == null) {
            root = new Node(key.charAt(0));
        }

        if (key.charAt(0) < root.data) {
            root.left = insert(root.left, key);
        } else if (key.charAt(0) > root.data) {
            root.right = insert(root.right, key);
        } else {
            if (key.length() > 1) {
                root.eq = insert(root.eq, key.substring(1));
            } else {
                root.isEndOfWord = true;
            }
        }
        return root;
    }

    public String traverse(Node root) {
        StringBuilder sb = new StringBuilder();
        traverseRec(root, sb, "");
        return sb.substring(0, sb.length() - 2);
    }

    private void traverseRec(Node root, StringBuilder sb, String word) {
        if (root == null) {
            return;
        }

        traverseRec(root.left, sb, word);

        if (root.isEndOfWord) {
            sb.append(word).append(root.data).append(", ");
        }

        traverseRec(root.eq, sb, word + root.data);
        traverseRec(root.right, sb, word);
    }

    public boolean search(Node root, String word) {
        if (root == null) {
            return false;
        }

        if (word.charAt(0) < root.data) {
            return search(root.left, word);
        } else if (word.charAt(0) > root.data) {
            return search(root.right, word);
        } else {
            if (word.length() == 1) {
                return root.isEndOfWord;
            }
            return search(root.eq, word.substring(1));
        }
    }
}
