package ds.array;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TripletsWithZeroSumTest {
    @Test
    public void shouldFindTripletsWithZeroSum() {
        TripletsWithZeroSum ts = new TripletsWithZeroSum();
        List<Triplet> triplets = ts.find(new int[] {0, -1, 2, -3, 1});
        // Sort: -3 -1 0 1 2
        assertNotNull(triplets);
        assertEquals(2, triplets.size());
    }
}
