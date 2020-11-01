package ds.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
    @Test
    public void sh() {
//        assertEquals(3, LongestIncreasingSubsequence.find(new int[] { 5, 8, 3, 7, 9, 1 }));
//        assertEquals(6, LongestIncreasingSubsequence.find(new int[] { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 }));
        assertEquals(6, LongestIncreasingSubsequence.find(new int[] { 0, 4, 12, 2, 10, 6, 9, 13, 3, 11, 7, 15 }));
    }
}
