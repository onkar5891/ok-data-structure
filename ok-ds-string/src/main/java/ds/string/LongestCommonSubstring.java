package ds.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

public class LongestCommonSubstring {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for (int i = 1; i <= t; i++) {
                String m = br.readLine();
                String s1 = br.readLine();
                String s2 = br.readLine();
                System.out.println(find(s1, s2));
            }
        }
    }

    static int find(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // Storing the count
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    // If characters are equal, new substring count is 1 greater than previously calculated substring count
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    // Check if it exceeds current max (res)
                    res = max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}
