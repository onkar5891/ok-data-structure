package dp.knapsack;

import static java.lang.Math.max;

// Bottom Up (no recursion)
public class KnapsackTabulation {
    // O(N*C), N - number of items, C - capacity
    public int solveKnapsack(int[] weights, int[] profits, int capacity) {
        // Base Cases
        if (capacity <= 0 || weights.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = weights.length;
        // To store max profits for every capacity of the Knapsack
        int[][] dp = new int[n][capacity + 1];

        for (int i = 0; i < n; i++) {
            dp[0][i] = 0;
        }

        // Knapsack having single weight
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        // process all sub-arrays for all the capacities
        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {
                int profit1 = 0;

                // include current item, if it is not more than capacity
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c - weights[i]];
                }

                // exclude the item
                int profit2 = dp[i - 1][c];
                // take maximum
                dp[i][c] = max(profit1, profit2);
            }
        }

        return dp[n - 1][capacity];
    }
}
