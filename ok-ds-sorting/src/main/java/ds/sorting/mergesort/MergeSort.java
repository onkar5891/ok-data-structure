package ds.sorting.mergesort;

import static java.util.Objects.isNull;

public class MergeSort {
    public int[] sort(int[] data) {
        if (isNull(data) || data.length == 0) {
            return data;
        }
        mergeSort(data, 0, data.length - 1);

        return data;
    }

    private void mergeSort(int[] data, int low, int high) {
        if (low < high) {
            // Avoiding overflow for large arrays. Same as (low + high) / 2
            int middle = low + (high - low) / 2;

            // Divide till arrays are of size 1
            mergeSort(data, low, middle);
            mergeSort(data, middle + 1, high);

            // Merge the two arrays to a single sorted array
            merge(data, low, middle, high);
        }
    }

    private void merge(int[] data, int low, int middle, int high) {
        int lLen = middle - low + 1;
        int rLen = high - middle;
        int[] left = new int[lLen];
        int[] right = new int[rLen];

        // Copy contents into left and right array
        for (int i = 0; i < lLen; i++) {
            left[i] = data[i + low];
        }
        for (int j = 0; j < rLen; j++) {
            right[j] = data[middle + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < lLen && j < rLen) {
            if (left[i] < right[j]) {
                data[k] = left[i];
                i++;
            } else {
                data[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < lLen) {
            data[k++] = left[i++];
        }

        while (j < rLen) {
            data[k++] = right[j++];
        }
    }
}
