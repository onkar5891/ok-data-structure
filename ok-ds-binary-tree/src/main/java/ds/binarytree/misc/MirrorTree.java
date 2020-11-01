package ds.binarytree.misc;

import ds.binarytree.Node;

public class MirrorTree {
    public void findMirror(Node root) {
        if (root == null) {
            return;
        }

        if (root.left != null && root.right != null) {
            swap(root.left, root.right);
            findMirror(root.left);
            findMirror(root.right);
        } else if (root.left != null) {
            root.right = new Node(root.left.value);
            root.left = null;
        } else if (root.right != null) {
            root.left = new Node(root.right.value);
            root.right = null;
        }
    }

    private void swap(Node left, Node right) {
        int t = left.value;
        left.value = right.value;
        right.value = t;
    }
}
