package ds.hashing;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class HashTableUsingArrayTest {
    @Test
    public void shouldIDSFaster() {
        HashTableUsingArray<String, Integer> ht = new HashTableUsingArray<>();
        ht.add("this", 1);
        ht.add("coder", 2);
        ht.add("this", 3);
        ht.add("hi", 5);

        assertEquals(3, ht.size());
        assertEquals(3, ht.get("this").intValue());
        assertEquals(3, ht.delete("this").intValue());
        assertNull(ht.delete("this"));
        assertEquals(2, ht.size());
    }
}
