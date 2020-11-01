package ds.bst;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @Before
    public void setUp() {
        bst = new BinarySearchTree();
    }

    @Test
    public void shouldInsert() {
        bst.insert(100);
        bst.insert(20);
        bst.insert(500);
        bst.insert(10);
        bst.insert(30);
        bst.insert(40);

        assertEquals("100, 20, 10, 30, 40, 500", bst.preorder());
    }

    @Test
    public void shouldSearch() {
        bst.insert(8);
        bst.insert(3);
        bst.insert(10);
        bst.insert(1);
        bst.insert(6);
        bst.insert(14);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);

        assertEquals(6, bst.search(6).value);
        assertNull(bst.search(11));
    }

    @Test
    public void shouldDelete() {
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        assertNotNull(bst.delete(20));
        assertEquals("30, 40, 50, 60, 70, 80", bst.inorder());
        bst.delete(30);
        assertEquals("40, 50, 60, 70, 80", bst.inorder());
        bst.delete(50);
        assertEquals("40, 60, 70, 80", bst.inorder());
    }

    @Test
    public void shouldFindHeight() {
        Node root = bst.insert(12);
        bst.insert(8);
        bst.insert(18);
        bst.insert(5);
        bst.insert(11);
        bst.insert(17);
        bst.insert(4);
        bst.insert(7);
        bst.insert(2);

        assertEquals(4, bst.height(root));
    }
}
