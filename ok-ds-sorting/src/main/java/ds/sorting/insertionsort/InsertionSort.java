package ds.sorting.insertionsort;

import static java.util.Objects.isNull;

public class InsertionSort {
    public int[] sort(int[] data) {
        if (isNull(data) || data.length == 0) {
            return data;
        }

        for (int i = 1; i < data.length; i++) {
            int key = data[i];
            int j = i - 1;

            // Move elements greater than key, one position ahead of their current position
            while (j >= 0 && data[j] > key) {
                data[j + 1] = data[j];
                j--;
            }
            data[j + 1] = key;
        }
        return data;
    }
}
