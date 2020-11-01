package ds.heap;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class KthClosestTest {
    private final KthClosest kc = new KthClosest();

    @Test
    public void shouldFindKClosestElements() {
        assertArrayEquals(new int[]{4, 5, 6}, kc.findKthClosestElementsToX(new int[]{2, 4, 5, 6, 9}, 3, 6));
        assertArrayEquals(new int[]{1, 2, 3, 4}, kc.findKthClosestElementsToX(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    @Test
    public void shouldFindClosestElement() {
        assertEquals(6, kc.findClosest(new int[]{2, 4, 5, 6, 9}, 6));
        assertEquals(2, kc.findClosest(new int[]{2, 4, 5, 6, 9}, 3));
        assertEquals(9, kc.findClosest(new int[]{2, 4, 5, 6, 9}, 8));
        assertEquals(6, kc.findClosest(new int[]{2, 4, 5, 6, 9}, 7));
        assertEquals(3, kc.findClosestIndex(new int[]{2, 4, 5, 6, 9}, 7));
    }
}
