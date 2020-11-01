package ds.sorting.quicksort;

import static java.util.Objects.isNull;

public class QuickSortWithFirstPivotElement {
    public int[] sort(int[] data) {
        if (isNull(data) || data.length == 0) {
            return data;
        }

        quickSort(data, 0, data.length - 1);
        return data;
    }

    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            // Find the pivot index
            int pi = partition(data, low, high);

            // Sort left of pivot
            quickSort(data, 0, pi - 1);
            // Sort right of pivot
            quickSort(data, pi + 1, high);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[low];
        int i = high + 1;

        // As we assigned first element as pivot, need to iterate from high to (low + 1)
        for (int j = high; j > low; j--) {
            // If current element is greater than pivot
            if (data[j] > pivot) {
                i--;
                // We need to swap elements at i, j because we know data[j] > pivot
                swap(data, i, j);
            }
        }
        swap(data, i - 1, low);

        return i - 1;
    }

    private void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
}
