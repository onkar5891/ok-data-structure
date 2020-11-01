package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubsequenceTest {
    private LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();

    @Test
    public void shouldFindIt() {
        String s = "GEEKSFORGEEKS";
        assertEquals(5, lps.findLps(s, 0, s.length() - 1));
    }

    @Test
    public void shouldFindIt$Dp() {
        assertEquals(5, lps.findLps$Dp("GEEKSFORGEEKS"));
        assertEquals(7, lps.findLps$Dp("GEEKS FOR GEEKS"));
    }
}
