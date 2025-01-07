import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> stringMatching(String[] words) {
        Set<String> ansSet = new HashSet<>(); // Use a set to avoid duplicates.

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[i].contains(words[j])) {
                    ansSet.add(words[j]);
                }
            }
        }

        return new ArrayList<>(ansSet); // Convert set to list.
    }
}
