package ds.array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletsWithZeroSum {
    public List<Triplet> find(int[] arr) {
        // Basic implementation takes 3 loops and checking every combination resulting in O(n^3) complexity
        List<Triplet> triplets = new ArrayList<>();

        for (int i = 0; i < arr.length - 1; i++) {
            Set<Integer> comp = new HashSet<>();

            // find sum with -arr[i] value
            for (int j = i + 1; j < arr.length; j++) {
                // x represents complement we need to search in the hash
                int x = -(arr[i] + arr[j]);
                if (comp.contains(x)) {
                    triplets.add(new Triplet(x, arr[i], arr[j]));
                } else {
                    // To store current value at j and then search for the complement -j, which will form a triplet with 0 sum
                    comp.add(arr[j]);
                }
            }
        }

        return triplets;
    }
}
