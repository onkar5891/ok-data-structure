package ds.sorting.quicksort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

public class QuickSortWithFirstPivotElementTest {
    private final QuickSortWithFirstPivotElement qs = new QuickSortWithFirstPivotElement();

    @Test
    public void shouldPerformQuickSort() {
        assertArrayEquals(
                new int[]{10, 20, 30, 40, 60, 70, 90},
                qs.sort(new int[]{30, 10, 60, 90, 70, 20, 40})
        );
    }

    @Test
    public void shouldNotSortForInvalidInput() {
        assertNull(qs.sort(null));
        assertArrayEquals(new int[0], qs.sort(new int[0]));
    }
}
