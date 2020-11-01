package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequnceTest {
    private LongestCommonSubsequnce lcs = new LongestCommonSubsequnce();

    @Test
    public void sh() {
        assertEquals(4, lcs.find("AGGTAB", "GXTXAYB"));
    }
}
