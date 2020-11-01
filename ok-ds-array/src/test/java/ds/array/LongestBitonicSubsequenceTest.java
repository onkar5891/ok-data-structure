package ds.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestBitonicSubsequenceTest {
    @Test
    public void shouldFindLongestBitonicSubsequence() {
        LongestBitonicSubsequence lbs = new LongestBitonicSubsequence();
        assertEquals(6, lbs.find(new int[]{1, 11, 2, 10, 4, 5, 2, 1}));
        assertEquals(5, lbs.find(new int[]{1, 11, 12, 13, 18}));
    }
}
