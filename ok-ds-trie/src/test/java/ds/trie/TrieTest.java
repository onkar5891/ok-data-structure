package ds.trie;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TrieTest {
    @Test
    public void shouldPerformTrieOperations() {
        Trie trie = new Trie();

        String[] keys = {"this", "a", "there", "the", "by", "bye", "their", "any"};
        Stream.of(keys).forEach(trie::insert);

        assertTrue(trie.search("a"));
        assertTrue(trie.search("any"));
        assertTrue(trie.search("the"));
        assertFalse(trie.search("that"));
    }
}
