package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinInsertionsForPalindromeTest {
    @Test
    public void shouldFindMinInsertionsForPalidrome() {
        MinInsertionsForPalindrome m = new MinInsertionsForPalindrome();
        assertEquals(3, m.find("geeks"));
        assertEquals(4, m.find("abcde"));
    }
}
