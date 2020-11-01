package ds.array;

import java.util.HashSet;
import java.util.Set;

public class PairExistenceWithGivenSum {
    public boolean pairExistsForSum(int[] arr, int sum) {
        Set<Integer> hash = new HashSet<>();

        for (int value : arr) {
            // If hash contains the value, pair exists
            if (hash.contains(value)) {
                return true;
            }
            // Add the complement to hash
            hash.add(sum - value);
        }
        return false;
    }

    public boolean pairExistsForSumInSortedRotated(int[] arr, int sum) {
        int i;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                break;
            }
        }
        // i + 1 will be smallest here
        int l = (i + 1) % n;
        // i will be largest element here
        int r = i;

        while (l != r) {
            int s = arr[l] + arr[r];
            if (s == sum) {
                return true;
            } else if (s < sum) {
                // Move l to upper side, in circular way
                l = (l + 1) % n;
            } else {
                // Move r to lower side, in circular way
                r = (n + r - 1) % n;
            }
        }

        return false;
    }
}
