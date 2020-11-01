package ds.ternary;

import org.junit.Test;

import static org.junit.Assert.*;

public class TernarySearchTreeTest {
    @Test
    public void shouldInsertTraverseSearch() {
        TernarySearchTree tst = new TernarySearchTree();
        Node root = tst.insert(null, "cat");
        root = tst.insert(root, "cats");
        root = tst.insert(root, "bug");
        root = tst.insert(root, "cub");
        root = tst.insert(root, "up");

        assertEquals("bug, cat, cats, cub, up", tst.traverse(root));
        assertTrue(tst.search(root, "cub"));
        assertFalse(tst.search(root, "bub"));
        assertFalse(tst.search(root, "cu"));
    }
}
