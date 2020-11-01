package dp.eqsubset;

public class EqualSubsetPartitionTabulation {
    public boolean canPartition(int[] nos) {
        int sum = 0;
        for (int no : nos) {
            sum += no;
        }

        if (sum % 2 != 0) {
            return false;
        }

        // to find a subset having total sum as sum / 2
        sum /= 2;

        int n = nos.length;
        // Storing partitions for every sum
        Boolean[][] dp = new Boolean[n][sum + 1];

        // populate 0th column, as 0 sum is possible without any element
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // with one number, we can form subset only when required sum is equal to its value
        for (int s = 1; s <= sum; s++) {
            dp[0][s] = (nos[0] == s);
        }

        // process for all subsets of all sums
        for (int i = 1; i < n; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i - 1][s]) {
                    dp[i][s] = dp[i - 1][s];
                } else if (nos[i] <= s) {
                    dp[i][s] = dp[i - 1][s - nos[i]];
                }
            }
        }

        return dp[n - 1][sum];
    }
}
