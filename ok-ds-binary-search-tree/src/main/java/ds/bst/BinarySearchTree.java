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

    private Node deleteRec(Node node, int key) {
        if (node == null) {
            return null;
        }

        if (key < node.value) {
            node.left = deleteRec(node.left, key);
        } else if (key > node.value) {
            node.right = deleteRec(node.right, key);
        } else {
            // key is found and node points to it

            // Case when node has one child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case when node has both children
            // Find the min value in right subtree
            node.value = findMin(node.right);
            // Delete the node with that value starting from the right subtree
            // For this node to be deleted
            // The recursive call will always reach the first case i.e. it will have 0 or 1 child, but not 2
            node.right = deleteRec(node.right, node.value);
        }
        return node;
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
