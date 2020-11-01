package ds.binarytree.misc;

import ds.binarytree.Node;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeAsSumOfInorderPredecessorAndSuccessorTest {
    private BinaryTreeAsSumOfInorderPredecessorAndSuccessor tree;

    @Test
    public void shouldReplaceNodesWithSum() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        tree = new BinaryTreeAsSumOfInorderPredecessorAndSuccessor(root);

        tree.replace();

        assertEquals("2, 9, 3, 11, 4, 13, 3", tree.inorder());
    }
}
