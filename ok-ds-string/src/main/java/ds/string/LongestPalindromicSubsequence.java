package ds.string;

import static java.lang.Math.max;

public class LongestPalindromicSubsequence {
    public int findLps(String s, int i, int j) {
        if (i == j) {
            return 1;
        }
        if (s.charAt(i) == s.charAt(j)) {
            if (i == j - 1) {
                return 2;
            } else {
                return findLps(s, i + 1, j - 1) + 2;
            }
        }
        return max(findLps(s, i + 1, j), findLps(s, i, j - 1));
    }

    public int findLps$Dp(String s) {
        int n = s.length();
        // Storing length of palindrome
        int[][] len = new int[n][n];

        // Each individual character in string is palindrome
        for (int i = 0; i < n; i++) {
            len[i][i] = 1;
        }

        // Calculate the table of every gap from 1 to n
        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                int j = i + gap;

                if (s.charAt(i) == s.charAt(j)) {
                    // If characters are equal, incrementing by 2 the value of previously calculated length
                    len[i][j] = len[i + 1][j - 1] + 2;
                } else {
                    // Otherwise, its the max of values from indexes [i, j - 1] and [i + 1, j]
                    len[i][j] = max(len[i][j - 1], len[i + 1][j]);
                }
            }
        }

        return len[0][n - 1];
    }
}
