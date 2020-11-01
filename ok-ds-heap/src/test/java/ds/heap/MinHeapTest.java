package ds.heap;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MinHeapTest {
    @Test
    public void shouldPerformHeapOperations() {
        MinHeap h = new MinHeap(11);

        h.insert(3);
        h.insert(2);
        assertArrayEquals(new int[] {2, 3}, h.elements());

        h.delete(1);
        assertArrayEquals(new int[] {2}, h.elements());

        h.insert(15);
        h.insert(5);
        h.insert(4);
        h.insert(45);
        assertArrayEquals(new int[] {2, 4, 5, 15, 45}, h.elements());

        assertEquals(2, h.extractMin());
        assertArrayEquals(new int[] {4, 15, 5, 45}, h.elements());

        h.decreaseKey(2, 1);
        assertArrayEquals(new int[] {1, 15, 4, 45}, h.elements());
    }
}
