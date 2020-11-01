package ds.array;

import static java.lang.Math.max;

public class MaxContiguousSubArraySum {
    public int maxSubArraySum(int[] arr) {
        // Based on Kadane's algorithm
        int maxSoFar = arr[0];
        int maxEndingHere = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere += arr[i];
            maxSoFar = max(maxSoFar, maxEndingHere);

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public int maxSubArraySum$Simple(int[] arr) {
        int maxSoFar = arr[0];
        int curMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            curMax = max(arr[i], curMax + arr[i]);
            maxSoFar = max(maxSoFar, curMax);
        }

        return maxSoFar;
    }
}
