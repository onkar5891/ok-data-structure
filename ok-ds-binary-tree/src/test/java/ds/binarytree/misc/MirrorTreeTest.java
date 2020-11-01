package ds.binarytree.misc;

import ds.binarytree.Node;
import org.junit.Test;

public class MirrorTreeTest {
    @Test
    public void shouldFindMirror() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);

        MirrorTree mt = new MirrorTree();
        mt.findMirror(root);
        System.out.println();
    }
}
