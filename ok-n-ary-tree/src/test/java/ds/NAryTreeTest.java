package ds;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NAryTreeTest {
    private NAryTree nary = new NAryTree();

    @Test
    public void shouldPerformLevelOrderTraversal() {
        Node root = new Node(10);
        root.children.add(new Node(2));
        root.children.add(new Node(34));
        root.children.add(new Node(56));
        root.children.add(new Node(100));
        root.children.get(0).children.add(new Node(77));
        root.children.get(0).children.add(new Node(88));
        root.children.get(2).children.add(new Node(1));
        root.children.get(3).children.add(new Node(7));
        root.children.get(3).children.add(new Node(8));
        root.children.get(3).children.add(new Node(9));

        assertEquals("10, 2, 34, 56, 100, 77, 88, 1, 7, 8, 9", nary.levelOrder(root));
    }

    @Test
    public void shouldFindHeight() {
        Node root = new Node(0);
        root.children.add(new Node(1));
        root.children.add(new Node(2));
        root.children.add(new Node(3));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        root.children.get(1).children.add(new Node(7));
        root.children.get(2).children.add(new Node(9));

        assertEquals(2, nary.height(root));
    }

    @Test
    public void shouldFindHeightOfSkewedTree() {
        Node root = new Node(0);
        root.children.add(new Node(1));
        root.children.get(0).children.add(new Node(2));
        root.children.get(0).children.get(0).children.add(new Node(3));
        root.children.get(0).children.get(0).children.get(0).children.add(new Node(4));
        root.children.get(0).children.get(0).children.get(0).children.get(0).children.add(new Node(5));

        assertEquals(5, nary.height(root));
    }
}
