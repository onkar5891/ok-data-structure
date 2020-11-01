package ds.array;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PivotedBinarySearchTest {
    @Test
    public void shouldSearch() {
        PivotedBinarySearch pbs = new PivotedBinarySearch();
        assertEquals(8, pbs.pivotedBinarySearch(new int[] {5, 6, 7, 8, 9, 10, 1, 2, 3}, 3));
        assertEquals(3, pbs.pivotedBinarySearch(new int[] {3, 4, 5, 1, 2}, 1));
    }
}
