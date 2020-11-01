package ds.sorting.quicksort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class QuickSortWithLastPivotElementTest {
    private final QuickSortWithLastPivotElement qs = new QuickSortWithLastPivotElement();

    @Test
    public void shouldPerformQuickSort() {
        assertArrayEquals(
                new int[] {10, 20, 30, 40, 60, 70, 90},
                qs.sort(new int[] {10, 30, 40, 20, 60, 90, 70})
        );
    }

    @Test
    public void shouldNotSortForInvalidInput() {
        assertNull(qs.sort(null));
        assertArrayEquals(new int[0], qs.sort(new int[0]));
    }
}
