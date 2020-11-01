package dp.subsetsum;

public class SubsetSum {
    public boolean sumExists(int[] nos, int sum) {
        int n = nos.length;
        Boolean[][] dp = new Boolean[n][sum + 1];

        // populate 0th column which indicates 0 sum is possible without any element
        for (int i = 0; i < nos.length; i++) {
            dp[0][i] = true;
        }

        // for single number, populate 0th row and the value is true only if sum is equal to the number
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = nos[0] == s;
        }

        // process all subsets for all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                // if we get sum 's' without number at index 'i'
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (nos[i] <= s) {
                    // else include the number and see if we can find a subset with remaining sum
                    dp[i][s] = dp[i - 1][s - nos[i]];
                }
            }
        }

        return dp[n - 1][sum];
    }
}
