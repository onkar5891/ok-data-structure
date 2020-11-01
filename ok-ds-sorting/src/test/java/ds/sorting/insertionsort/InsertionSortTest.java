package ds.sorting.insertionsort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class InsertionSortTest {
    private InsertionSort is = new InsertionSort();

    @Test
    public void shouldPerformInsertionSort() {
        assertArrayEquals(
                new int[] {1, 2, 3, 4, 5, 6, 10, 12},
                is.sort(new int[] {4, 3, 2, 10, 12, 1, 5, 6})
        );
    }

    @Test
    public void shouldNotSortForInvalidInput() {
        assertNull(is.sort(null));
        assertArrayEquals(
                new int[0],
                is.sort(new int[0])
        );
    }
}
