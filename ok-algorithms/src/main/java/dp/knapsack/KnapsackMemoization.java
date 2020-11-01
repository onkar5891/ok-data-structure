package dp.knapsack;

import static java.lang.Math.max;
import static java.util.Objects.nonNull;

// Top Down
public class KnapsackMemoization {
    public int solveKnapsack(int[] weights, int[] profits, int capacity) {
        Integer[][] dp = new Integer[weights.length][capacity + 1];
        return knapsackRecursive(dp, weights, profits, capacity, 0);
    }

    // O(N*C), N - number of items, C - capacity
    private int knapsackRecursive(Integer[][] dp, int[] weights, int[] profits, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        // if problem is solved previously, return the value directly
        if (nonNull(dp[index][capacity])) {
            return dp[index][capacity];
        }

        int profit1 = 0;
        // include the item if its weight is less than the capacity
        if (weights[index] <= capacity) {
            profit1 = profits[index] + knapsackRecursive(dp, weights, profits, capacity - weights[index], index + 1);
        }

        // exclude the item
        int profit2 = knapsackRecursive(dp, weights, profits, capacity, index + 1);

        // take maximum and store in the array
        return (dp[index][capacity] = max(profit1, profit2));
    }
}
