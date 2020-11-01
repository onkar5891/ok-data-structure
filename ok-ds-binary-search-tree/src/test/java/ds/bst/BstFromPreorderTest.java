package ds.bst;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class BstFromPreorderTest {
    private BstFromPreorder bst = new BstFromPreorder();

    @Test
    public void shouldConstructBstFromPreorder() {
        Node root = bst.constructFromPreorder(new int[] {10, 5, 1, 7, 40, 50});

        assertNotNull(root);
        assertEquals("1, 5, 7, 10, 40, 50", bst.inorder(root));
    }
}
