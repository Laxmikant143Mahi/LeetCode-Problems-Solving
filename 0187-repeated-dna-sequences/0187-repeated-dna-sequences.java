import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() <= 10) return result; // No sequences of length 10 are possible
        
        HashSet<String> seen = new HashSet<>();
        HashSet<String> added = new HashSet<>();
        
        for (int i = 0; i <= s.length() - 10; i++) {
            String substring = s.substring(i, i + 10);
            if (seen.contains(substring)) {
                if (!added.contains(substring)) {
                    result.add(substring);
                    added.add(substring);
                }
            } else {
                seen.add(substring);
            }
        }
        
        return result;
    }
}
