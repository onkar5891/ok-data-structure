package dp.subsetsum;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SubsetSumTest {
    @Test
    public void shouldFindIfSumExists() {
        SubsetSum s = new SubsetSum();
        assertTrue(s.sumExists(new int[]{1, 2, 3, 7}, 6));
        // assertTrue(s.sumExists(new int[]{1, 2, 7, 1, 5}, 10));
    }
}
