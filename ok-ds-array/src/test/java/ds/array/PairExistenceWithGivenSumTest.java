package ds.array;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class PairExistenceWithGivenSumTest {
    @Test
    public void shouldFindIfPairExists() {
        PairExistenceWithGivenSum ps = new PairExistenceWithGivenSum();
        assertTrue(ps.pairExistsForSum(new int[] {0, -1, -3, -2, 2}, -2));
    }

    @Test
    public void shouldFindIfPairExistsInSortedRotatedArray() {
        PairExistenceWithGivenSum ps = new PairExistenceWithGivenSum();
        assertTrue(ps.pairExistsForSumInSortedRotated(new int[] {11, 15, 6, 8, 9, 10}, 16));
    }
}
