package ds.array;

import static java.text.MessageFormat.format;

public class SumOfBitDifferencesAmongAllPairs {
    public int findSumOfBitDifferences(int[] arr) {
        int result = 0;

        // 32 is considered as constant to represent max number of bits required to store integer value
        for (int i = 0; i < 32; i++) {
            int count = 0;
            // For every ith bit, right shift every element of arr
            for (int num : arr) {
                // Keep track of elements whose right shift operation is 0 or 1
                if ((num & (1 << i)) == 0) {
                    System.out.println(format("{0} & {1} = 0, incrementing count", num, (1 << i)));
                    ++count;
                }
            }
            // If we get m as count, there will be len(arr) - m elements where bit difference exists
            // So, multiplying these operands will give the correct combination of differences
            // As pairs (x, y) and (y, x) exist, we need to multiply by 2
            result += (count * (arr.length - count)) * 2;
            System.out.println(format("Count for {0}: {1}, Result: {2}", i, count, result));
        }

        return result;
    }

    public int findBitDifference(int a, int b) {
        int result = 0;

        // 32 is considered as constant to represent max number of bits required to store integer value
        for (int i = 0; i < 32; i++) {
            // Right shifting both the elements and if they are unequal, there is a bit difference
            if (((a >> i) & 1) != ((b >> i) & 1)) {
                ++result;
            }
        }

        return result;
    }
}
