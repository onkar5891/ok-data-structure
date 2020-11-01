package ds.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxContiguousSubArraySumTest {
    @Test
    public void shouldFindMaxSubArraySum() {
        MaxContiguousSubArraySum ms = new MaxContiguousSubArraySum();
        assertEquals(7, ms.maxSubArraySum(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
        assertEquals(-1, ms.maxSubArraySum(new int[] {-2, -3, -1, -2}));
        assertEquals(7, ms.maxSubArraySum$Simple(new int[] {-2, -3, 4, -1, -2, 1, 5, -3}));
        assertEquals(-1, ms.maxSubArraySum$Simple(new int[] {-2, -3, -1, -2}));
    }
}
