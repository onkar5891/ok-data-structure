package ds.binarytree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    private BinaryTree tree;

    @Before
    public void setUp() {
        tree = new BinaryTree();
    }

    @Test
    public void shouldInsertInLevelOrderFashion() {
        tree.insert(10);
        tree.insert(11);
        tree.insert(9);
        tree.insert(7);
        tree.insert(15);
        tree.insert(8);

        assertEquals("10, 11, 7, 15, 9, 8", tree.preorder());
        assertEquals(tree.inorder(), tree.inorderWithoutRecursion());
    }

    @Test
    public void shouldDeleteNode() {
        tree.insert(13);
        tree.insert(12);
        tree.insert(10);
        tree.insert(4);
        tree.insert(19);
        tree.insert(16);
        tree.insert(9);

        tree.delete(12);
        assertEquals("13, 9, 4, 19, 10, 16", tree.preorder());
        assertEquals(tree.inorder(), tree.inorderWithoutRecursion());
    }

    @Test
    public void shouldPerformInOrderWithoutRecursion() {
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        assertEquals(tree.inorder(), tree.inorderWithoutRecursion());
    }
}
