package ds.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthLargestTest {
    @Test
    public void shouldFindKthLargestElement() {
        KthLargest kl = new KthLargest(new int[] {4, 1, 3, 12, 7, 14}, 3);

        assertEquals(7, kl.add(6));
        assertEquals(12, kl.add(13));
        assertEquals(12, kl.add(4));
    }
}
