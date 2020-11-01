package ds.array;

import static java.lang.Math.max;
import static java.util.Objects.isNull;

// Bitonic sequence indicates array increases first and decreases later
// The idea is to find LIS and LDS from the array and sum the values from each index to get the max value of sequence
public class LongestBitonicSubsequence {
    public int find(int[] arr) {
        if (isNull(arr) || arr.length == 0) {
            return -1;
        }

        int n = arr.length;
        int[] lis = findIncreasingSubsequence(arr, n);
        int[] lds = findDecreasingSubsequence(arr, n);

        int max = lis[0] + lds[0] - 1;
        for (int i = 1; i < arr.length; i++) {
            int current = lis[i] + lds[i] - 1;
            if (max < current) {
                max = current;
            }
        }

        return max;
    }

    private int[] findDecreasingSubsequence(int[] arr, int n) {
        int[] lds = new int[n];
        lds[0] = 1;

        for (int i = 1; i < n; i++) {
            lds[i] = 1;
            for (int j = 0; j < i; j++) {
                // If subsequence is increasing, modify count of lds[i]
                if (arr[j] > arr[i]) {
                    lds[i] = max(lds[i], 1 + lds[j]);
                }
            }
        }

        return lds;
    }

    private int[] findIncreasingSubsequence(int[] arr, int n) {
        int[] lis = new int[n];
        lis[0] = 1;

        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                // If subsequence is decreasing, modify count of lis[i]
                if (arr[j] < arr[i]) {
                    lis[i] = max(lis[i], 1 + lis[j]);
                }
            }
        }

        return lis;
    }
}
