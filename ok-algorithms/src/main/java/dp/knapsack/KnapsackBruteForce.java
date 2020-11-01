package dp.knapsack;

import static java.lang.Math.max;

public class KnapsackBruteForce {
    public int solveKnapsack(int[] weights, int[] profits, int capacity) {
        return knapsackRecursive(weights, profits, capacity, 0);
    }

    // O(2^n), n - number of items
    private int knapsackRecursive(int[] weights, int[] profits, int capacity, int index) {
        if (capacity <= 0 || index >= weights.length) {
            return 0;
        }

        int profit1 = 0;
        // include the item if its weight is less than the capacity
        if (weights[index] <= capacity) {
            profit1 = profits[index] + knapsackRecursive(weights, profits, capacity - weights[index], index + 1);
        }

        // exclude the item
        int profit2 = knapsackRecursive(weights, profits, capacity, index + 1);

        // take maximum
        return max(profit1, profit2);
    }
}
