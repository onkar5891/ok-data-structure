package ds.binarytree;

import ds.binarytree.traversal.StandardPreInPost;

public class BinaryTreeFromPreAndIn {
    private static int preIndex = 0;
    private final StandardPreInPost traversal = new StandardPreInPost();
    private Node root;

    public void construct(int[] inorder, int[] preorder) {
         root = buildTree(inorder, preorder, 0, inorder.length - 1);
    }

    private Node buildTree(int[] inorder, int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        Node n = new Node(preorder[preIndex++]);
        if (inStart == inEnd) {
            return n;
        }

        int inIndex = search(inorder, inStart, inEnd, n.value);
        n.left = buildTree(inorder, preorder, inStart, inIndex - 1);
        n.right = buildTree(inorder, preorder, inIndex + 1, inEnd);

        return n;
    }

    private int search(int[] data, int inStart, int inEnd, int value) {
        int i;
        for (i = inStart; i <= inEnd; i++) {
            if (data[i] == value) {
                return i;
            }
        }
        return i;
    }

    public String postorder() {
        return traversal.postorder(root);
    }

    public String preorder() {
        return traversal.preorder(root);
    }

    public String inorder() {
        return traversal.inorder(root);
    }
}
