package ds.string;

import java.util.ArrayList;
import java.util.List;

public class StringPermutation {
    List<String> permute(String s) {
        List<String> permutations = new ArrayList<>();
        permuteHelper(new StringBuilder(s), "", permutations);

        return permutations;
    }

    private void permuteHelper(StringBuilder sb, String chosen, List<String> permutations) {
        if (sb.length() == 0) {
            permutations.add(chosen);
            return;
        }

        for (int i = 0; i < sb.length(); i++) {
            // choose
            char c = sb.charAt(i);
            sb.deleteCharAt(i);
            chosen += c;

            // explore
            permuteHelper(sb, chosen, permutations);

            // un-choose
            sb.insert(i, c);
            chosen = chosen.substring(0, chosen.length() - 1);
        }
    }
}
