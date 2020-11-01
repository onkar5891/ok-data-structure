package ds.string;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdjacentStringRemovalTest {
    @Test
    public void sh() {
        assertEquals("a", AdjacentStringRemoval.remove("a"));
        assertEquals("gksforgk", AdjacentStringRemoval.remove("geeksforgeek"));
        assertEquals("acac", AdjacentStringRemoval.remove("acaaabbbacdddd"));
        assertEquals("mpie", AdjacentStringRemoval.remove("mississipie"));
    }

    @Test
    public void shStack() {
        assertEquals("a", AdjacentStringRemoval.rmStack("a"));
        assertEquals("gksforgk", AdjacentStringRemoval.rmStack("geeksforgeek"));
        assertEquals("acac", AdjacentStringRemoval.rmStack("acaaabbbacdddd"));
        assertEquals("mpie", AdjacentStringRemoval.rmStack("mississipie"));
    }
}
