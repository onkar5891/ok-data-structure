package ds.heap;

import static java.lang.Math.abs;

public class KthClosest {
    public int[] findKthClosestElementsToX(int[] arr, int k, int x) {
        int closestIndex = findClosestIndex(arr, x);
        MinHeap minHeap = new MinHeap(2 * (k - 1) + 1);
        minHeap.insert(arr[closestIndex]);

        for (int i = closestIndex - 1, count = 1; i >= 0 && count <= k - 1; i--, count++) {
            minHeap.insert(arr[i]);
        }

        for (int i = closestIndex + 1, count = 1; i < arr.length && count <= k - 1; i++, count++) {
            minHeap.insert(arr[i]);
        }

        int[] kClosest = new int[k];
        for (int i = 0; i < k; i++) {
            kClosest[i] = minHeap.extractMin();
        }

        return kClosest;
    }

    public int findClosest(int[] arr, int x) {
        return arr[findClosestIndex(arr, x)];
    }

    int findClosestIndex(int[] arr, int x) {
        int l = 0;
        int h = arr.length - 1;

        int diff = Integer.MAX_VALUE;
        int closestIndex = Integer.MAX_VALUE;

        while (l < h) {
            int mid = (l + h) / 2;

            if (diff > abs(arr[mid] - x)) {
                diff = abs(arr[mid] - x);
                closestIndex = mid;
            }

            if (x == arr[mid]) {
                return mid;
            } else if (x < arr[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (closestIndex > 0 && closestIndex < arr.length - 1) {
            int a = abs(x - arr[closestIndex - 1]);
            int b = abs(x - arr[closestIndex]);
            int c = abs(x - arr[closestIndex + 1]);
            int min = Math.min(a, Math.min(b, c));

            if (min == a) {
                return closestIndex - 1;
            } else if (min == b) {
                return closestIndex;
            }
            return closestIndex + 1;
        }

        return closestIndex;
    }
}
