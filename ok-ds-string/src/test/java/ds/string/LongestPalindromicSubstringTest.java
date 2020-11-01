package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class LongestPalindromicSubstringTest {
    @Test
    public void sh() {
        assertNull(LongestPalindromicSubstring.lp(null));
        assertEquals("a", LongestPalindromicSubstring.lp("a"));
        assertEquals("aabbaa", LongestPalindromicSubstring.lp("aaaabbaa"));
        assertEquals("rr", LongestPalindromicSubstring.lp("qrrc"));
    }
}
