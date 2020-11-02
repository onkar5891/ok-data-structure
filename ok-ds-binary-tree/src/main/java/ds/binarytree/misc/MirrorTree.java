package ds.binarytree.misc;

import ds.binarytree.Node;

public class MirrorTree {
    public void findMirror(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            // If node has both children, swap the contents
            swap(root.left, root.right);
            // Recursively find mirror for left child
            findMirror(root.left);
            // Recursively find mirror for left child
            findMirror(root.right);
        } else if (root.left != null) {
            // If node contains only the left child, make it as right child
            root.right = new Node(root.left.value);
            root.left = null;
        } else if (root.right != null) {
            // If node contains only the right child, make it as left child
            root.left = new Node(root.right.value);
            root.right = null;
        }
        // Note: Nothing to do for leaf node
    }

    private void swap(Node left, Node right) {
        int t = left.value;
        left.value = right.value;
        right.value = t;
    }
}
