package ds.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfBitDifferencesAmongAllPairsTest {
    private final SumOfBitDifferencesAmongAllPairs sbd = new SumOfBitDifferencesAmongAllPairs();

    @Test
    public void shouldFindSumOfBitDifferencesOfAllPairs() {
        assertEquals(8, sbd.findSumOfBitDifferences(new int[] {1, 3, 5}));
    }

    @Test
    public void shouldFindBitDifference() {
        assertEquals(2, sbd.findBitDifference(12, 15));
        assertEquals(3, sbd.findBitDifference(3, 16));
    }
}
