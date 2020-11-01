package dp.eqsubset;

import static java.util.Objects.isNull;

public class EqualSubsetPartition {
    public boolean canPartition(int[] nos) {
        int sum = 0;
        for (int no : nos) {
            sum += no;
        }

        if (sum % 2 != 0) {
            return false;
        }

        Boolean[][] dp = new Boolean[nos.length][sum / 2 + 1];
        return canPartition(dp, nos, sum / 2, 0);
    }

    private boolean canPartition(Boolean[][] dp, int[] nos, int sum, int index) {
        if (sum == 0) {
            return true;
        } else if (nos.length == 0 || index >= nos.length) {
            return false;
        }

        if (isNull(dp[index][sum])) {
            if (nos[index] <= sum) {
                if (canPartition(dp, nos, sum - nos[index], index + 1)) {
                    dp[index][sum] = true;
                    return true;
                }
            }

            dp[index][sum] = canPartition(dp, nos, sum, index + 1);
        }

        return dp[index][sum];
    }
}
