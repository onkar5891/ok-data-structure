package ds.sorting.mergesort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class MergeSortTest {
    private final MergeSort ms = new MergeSort();

    @Test
    public void shouldPerformMergeSort() {
        assertArrayEquals(
                new int[] {3, 9, 10, 27, 38, 43, 82},
                ms.sort(new int[] {38, 27, 43, 3, 9, 82, 10})
        );
    }

    @Test
    public void shouldNotSortForInvalidInput() {
        assertNull(ms.sort(null));
        assertArrayEquals(
                new int[0],
                ms.sort(new int[0])
        );
    }
}
