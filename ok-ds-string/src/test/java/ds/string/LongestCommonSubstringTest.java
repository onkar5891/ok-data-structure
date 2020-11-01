package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LongestCommonSubstringTest {
    @Test
    public void sh() {
        assertEquals(1, LongestCommonSubstring.find("ABC", "AC"));
        assertEquals(4, LongestCommonSubstring.find("ABCDGH", "ACDGHR"));
    }
}
