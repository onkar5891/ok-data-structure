package ds.string;

import static java.lang.Integer.*;
import static java.util.Objects.isNull;

public class MinInsertionsForPalindrome {
    public int find(String str) {
        if (isNull(str) || str.isEmpty()) {
            return -1;
        }

        int n = str.length();
        int[][] dp = new int[n][n];

        for (int gap = 1; gap < n; gap++) {
            for (int l = 0, h = gap; h < n; l++, h++) {
                if (str.charAt(l) == str.charAt(h)) {
                    dp[l][h] = dp[l + 1][h - 1];
                } else {
                    dp[l][h] = 1 + min(dp[l][h - 1], dp[l + 1][h]);
                }
            }
        }

        return dp[0][n - 1];
    }
}

// Note: For MinDeletionsToFormPalindrome, it is calculated by finding longest palindromic subsequence and then (n - len(lps))