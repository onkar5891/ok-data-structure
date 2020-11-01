package ds.array;

public class PivotedBinarySearch {
    public int pivotedBinarySearch(int[] arr, int key) {
        return pbs(arr, 0, arr.length - 1, key);
    }

    private int pbs(int[] arr, int l, int h, int key) {
        if (l > h) {
            return -1;
        }

        int mid = (l + h) / 2;
        // If mid index is the search key, return mid
        if (arr[mid] == key) {
            return mid;
        }

        // If arr[l..mid] is sorted
        if (arr[l] <= arr[mid]) {
            // Perform normal BS
            if (key >= arr[l] && key <= arr[mid]) {
                return pbs(arr, l, mid - 1, key);
            }
            return pbs(arr, mid + 1, h, key);
        } else {
            // If arr[l..mid] is not sorted (the case we find pivot element), then arr[mid..h] must be sorted
            // So, perform BS on arr[mid..h]
            if (key >= arr[mid] && key <= arr[h]) {
                return pbs(arr, mid + 1, h, key);
            }
            // If key is not found in arr[mid..h], search in arr[l..mid-1]
            return pbs(arr, l, mid - 1, key);
        }
    }
}
