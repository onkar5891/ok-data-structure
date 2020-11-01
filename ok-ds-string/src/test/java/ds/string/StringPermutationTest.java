package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringPermutationTest {
    @Test
    public void sh() {
        StringPermutation sp = new StringPermutation();
        assertEquals(6, sp.permute("abc").size());
        assertEquals(24, sp.permute("abcd").size());
    }
}
