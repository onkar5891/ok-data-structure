package ds.string;

import static java.lang.Math.max;

public class LongestCommonSubsequnce {
    public int find(String s1, String s2) {
        if (s1.isEmpty() || s2.isEmpty()) {
            return 0;
        }

        int m = s1.length();
        int n = s2.length();
        // Storing subsequence count
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If characters are equal, new subsequence count is 1 greater than previously calculated subsequence count
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Otherwise, its the max of values at index [i - 1, j] and [i, j - 1]
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
