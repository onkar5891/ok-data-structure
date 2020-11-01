package ds.avl;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AvlTreeTest {
    private AvlTree avl;

    @Before
    public void setUp() {
        avl = new AvlTree();
    }

    @Test
    public void shouldInsertWithRR() {
        avl.insert(13);
        avl.insert(10);
        avl.insert(15);
        avl.insert(16);
        avl.insert(5);
        avl.insert(11);
        avl.insert(4);
        avl.insert(8);

        // Needs re-balancing here
        avl.insert(3);
        assertEquals("3:0, 4:1, 5:0, 8:0, 10:0, 11:0, 13:1, 15:-1, 16:0", avl.inorder());
    }

    @Test
    public void shouldInsertWithLL() {
        avl.insert(30);
        avl.insert(5);
        avl.insert(35);
        avl.insert(32);
        avl.insert(40);

        // Need re-balancing here
        avl.insert(45);
        assertEquals("5:0, 30:0, 32:0, 35:0, 40:-1, 45:0", avl.inorder());
    }

    @Test
    public void shouldInsertWithLR() {
        avl.insert(13);
        avl.insert(10);
        avl.insert(15);
        avl.insert(5);
        avl.insert(11);
        avl.insert(16);
        avl.insert(4);
        avl.insert(6);

        // Need re-balancing here
        avl.insert(7);
        assertEquals("4:0, 5:1, 6:0, 7:0, 10:0, 11:0, 13:1, 15:-1, 16:0", avl.inorder());
    }

    @Test
    public void shouldInsertWithRL() {
        avl.insert(5);
        avl.insert(2);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);
        avl.insert(6);
        avl.insert(9);
        avl.insert(3);
        avl.insert(16);

        // Need re-balancing here
        avl.insert(15);
        assertEquals("1:0, 2:-1, 3:0, 4:1, 5:0, 6:0, 7:-1, 9:0, 15:0, 16:0", avl.inorder());
    }

    @Test
    public void shouldDelete() {
        avl.insert(5);
        avl.insert(2);
        avl.insert(7);
        avl.insert(1);
        avl.insert(4);
        avl.insert(6);
        avl.insert(9);
        avl.insert(3);

        avl.insert(16);
        avl.delete(16);
        assertEquals("1:0, 2:-1, 3:0, 4:1, 5:1, 6:0, 7:0, 9:0", avl.inorder());

        avl.insert(16);
        avl.delete(4);
        assertEquals("1:0, 2:0, 3:0, 5:-1, 6:0, 7:-1, 9:-1, 16:0", avl.inorder());

        avl.insert(4);
        avl.delete(5);
        assertEquals("1:0, 2:-1, 3:-1, 4:0, 6:1, 7:0, 9:0, 16:0", avl.inorder());
    }
}
