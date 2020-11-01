package ds.avl;

import static java.lang.Math.*;
import static java.util.Objects.isNull;

public class AvlTree {
    private final StandardPreInPost traversal = new StandardPreInPost();
    private Node root;

    public Node insert(int v) {
        root = insertRec(root, v);
        return root;
    }

    private int height(Node node) {
        if (isNull(node)) {
            return 0;
        }
        return node.height;
    }

    private Node insertRec(Node node, int v) {
        if (node == null) {
            return new Node(v);
        }

        if (v < node.value) {
            node.left = insertRec(node.left, v);
        } else {
            node.right = insertRec(node.right, v);
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = balanceFactor(node);
        node.balance = balance;

        // Perform RR(node)
        if (balance > 1 && v < node.left.value) {
            return rightRotate(node);
        }

        // Perform LR - LL(node.left), RR(node)
        if (balance > 1 && v > node.left.value) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Perform LL(node)
        if (balance < -1 && v > node.right.value) {
            return leftRotate(node);
        }

        // Perform RL - RR(node.right), LL(node)
        if (balance < -1 && v < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // z - first imbalanced node
    // y - right child of z
    private Node leftRotate(Node z) {
        Node y = z.right;
        Node t2 = y.left;
        y.left = z;
        z.right = t2;

        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        z.balance = balanceFactor(z);
        y.balance = balanceFactor(y);

        return y;
    }

    // z - first imbalanced node
    // y - left child of z
    private Node rightRotate(Node z) {
        Node y = z.left;
        Node t2 = y.right;
        y.right = z;
        z.left = t2;

        z.height = 1 + max(height(z.left), height(z.right));
        y.height = 1 + max(height(y.left), height(y.right));

        z.balance = balanceFactor(z);
        y.balance = balanceFactor(y);

        return y;
    }

    private int balanceFactor(Node node) {
        if (isNull(node)) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    public String inorder() {
        return traversal.inorder(root);
    }

    public Node delete(int v) {
        return deleteRec(root, v);
    }

    private Node deleteRec(Node node, int v) {
        if (node == null) {
            return null;
        }

        if (v < node.value) {
            node.left = deleteRec(node.left, v);
        } else if (v > node.value) {
            node.right = deleteRec(node.right, v);
        } else {
            // If node has 0 or 1 child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // If node has 2 children
            node.value = findMin(node.right);
            // Delete inorder successor
            node.right = deleteRec(node.right, node.value);
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = balanceFactor(node);
        node.balance = balance;

        if (balance > 1 && balanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }

        if (balance > 1 && balanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && balanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }

        if (balance < -1 && balanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    private int findMin(Node node) {
        int min = node.value;
        while (node.left != null) {
            min = node.left.value;
            node = node.left;
        }
        return min;
    }
}
