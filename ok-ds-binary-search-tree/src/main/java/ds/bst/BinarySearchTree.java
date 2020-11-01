package ds.bst;

import static java.lang.Math.max;

public class BinarySearchTree {
    private final StandardPreInPost traversal = new StandardPreInPost();
    private Node root;

    public Node insert(int v) {
        root = insertRec(root, v);
        return root;
    }

    private Node insertRec(Node root, int v) {
        if (root == null) {
            root = new Node(v);
            return root;
        }

        if (v < root.value) {
            root.left = insertRec(root.left, v);
        } else {
            root.right = insertRec(root.right, v);
        }

        System.out.println("V: " + root.value);
        return root;
    }

    public String preorder() {
        return traversal.preorder(root);
    }

    public Node search(int key) {
        return searchRec(root, key);
    }

    private Node searchRec(Node temp, int key) {
        if (temp == null) {
            return null;
        } else if (key == temp.value) {
            return temp;
        }

        if (key < temp.value) {
            return searchRec(temp.left, key);
        }
        return searchRec(temp.right, key);
    }

    public Node delete(int key) {
        return deleteRec(root, key);
    }

    private Node deleteRec(Node temp, int key) {
        if (temp == null) {
            return null;
        }

        if (key < temp.value) {
            temp.left = deleteRec(temp.left, key);
        } else if (key > temp.value) {
            temp.right = deleteRec(temp.right, key);
        } else {
            if (temp.left == null) {
                return temp.right;
            } else if (temp.right == null) {
                return temp.left;
            }

            temp.value = findMin(temp.right);
            temp.right = deleteRec(temp.right, temp.value);
        }
        return temp;
    }

    public int height(Node temp) {
        if (temp == null) {
            return -1;
        }
        return 1 + max(height(temp.left), height(temp.right));
    }

    private int findMin(Node temp) {
        int v = temp.value;
        while (temp.left != null) {
            v = temp.left.value;
            temp = temp.left;
        }

        return v;
    }

    public String inorder() {
        return traversal.inorder(root);
    }
}
