package ds.string;

import java.util.Scanner;

import static java.util.Objects.isNull;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            for (int i = 1; i <= n; i++) {
                System.out.println(lp(sc.next()));
            }
        }
    }

    static String lp(String str) {
        if (isNull(str)) {
            return null;
        } else if (str.isEmpty() || str.length() == 1) {
            return str;
        }

        int n = str.length();
        // Storing which indexes form a palindrome, table is filled in bottom-up manner
        boolean[][] bp = new boolean[n][n];

        // Each individual character in a string is palindrome
        for (int i = 0; i < n; i++) {
            bp[i][i] = true;
        }

        int diff = 0;
        int li = 0;
        int lj = 0;

        // Calculate for unit gap of indexes in the string (e.g.: (0, 1), (1, 2) ... (n - 2, n - 1))
        for (int i = 0, j = i + 1; j < n; i++, j++) {
            // If characters are equal, it is a palindrome (e.g.: "aa" in string "caab")
            if (str.charAt(i) == str.charAt(j)) {
                if (diff < j - i) {
                    diff = j - i;
                    li = i;
                    lj = j;
                }
                bp[i][j] = true;
            }
        }

        // Calculate for gap from 2 to n
        for (int gap = 2; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                // Comparison for gap 2: (0, 2), (1, 3), (2, 4)
                // Comparison for gap 3: (0, 3), (1, 4), (2, 5)
                int j = i + gap;
                if (str.charAt(i) == str.charAt(j) && bp[i + 1][j - 1]) {
                    if (diff < j - i) {
                        diff = j - i;
                        li = i;
                        lj = j;
                    }
                    bp[i][j] = true;
                }
            }
        }
        return str.substring(li, lj + 1);
    }
}
