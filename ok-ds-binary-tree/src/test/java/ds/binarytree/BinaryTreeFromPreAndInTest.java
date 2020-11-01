package ds.binarytree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeFromPreAndInTest {
    @Test
    public void shouldConstruct() {
        BinaryTreeFromPreAndIn tree = new BinaryTreeFromPreAndIn();
        tree.construct(new int[] {4, 2, 5, 1, 6, 3}, new int[] {1, 2, 4, 5, 3, 6});

        assertEquals("1, 2, 4, 5, 3, 6", tree.preorder());
        assertEquals("4, 2, 5, 1, 6, 3", tree.inorder());
        assertEquals("4, 5, 2, 6, 3, 1", tree.postorder());
    }
}
