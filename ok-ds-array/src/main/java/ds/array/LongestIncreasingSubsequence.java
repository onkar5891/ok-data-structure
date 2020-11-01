package ds.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static java.lang.Math.max;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            for (int i = 1; i <= t; i++) {
                String s1 = br.readLine();
                String s2 = br.readLine();
                String[] sp = s2.split("\\s+");
                int[] nums = new int[sp.length];

                for (int j = 0; j < nums.length; j++) {
                    nums[j] = Integer.parseInt(sp[j]);
                }
                System.out.println(find(nums));
            }
        }
    }

    public static int find(int[] nums) {
        int n = nums.length;
        // Each dp element indicates count of increasing subsequences till that index
        int[] dp = new int[n];
        // Individual number is counted as 1
        dp[0] = 1;

        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // If the subsequence is increasing, modify count of dp[i]
                if (nums[j] < nums[i]) {
                    dp[i] = max(dp[i], 1 + dp[j]);
                }
            }
        }

        // Find the max value from dp array to get longest increasing subsequence
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
        }

        return max;
    }
}
