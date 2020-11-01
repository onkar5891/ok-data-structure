package ds.binarytree.misc;

import ds.binarytree.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PathSumTest {
    @Test
    public void shouldFindIfPathExistsForGivenSum() {
        Node root = new Node(5);
        root.left = new Node(4);
        root.right = new Node(8);
        root.left.left = new Node(11);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right.right.right = new Node(1);

        PathSum ps = new PathSum(root);
        assertTrue(ps.pathExistsWithSum(22));
        assertFalse(ps.pathExistsWithSum(28));
        assertFalse(ps.pathExistsWithSum(17));
    }
}
