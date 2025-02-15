import java.util.HashMap;
import java.util.Map;

class Solution {
    public int rearrangeCharacters(String s, String target) {
        
        HashMap<Character, Integer> targetFreq = new HashMap<>();
        HashMap<Character, Integer> sFreq = new HashMap<>();

        // Count frequency of characters in target
        for (char ch : target.toCharArray()) {
            targetFreq.put(ch, targetFreq.getOrDefault(ch, 0) + 1);
        }

        // Count frequency of relevant characters in s
        for (char ch : s.toCharArray()) {
            if (targetFreq.containsKey(ch)) {
                sFreq.put(ch, sFreq.getOrDefault(ch, 0) + 1);
            }
        }

        // Find the limiting factor by dividing available chars by required chars
        int minValue = Integer.MAX_VALUE;
        for (Map.Entry<Character, Integer> entry : targetFreq.entrySet()) {
            char ch = entry.getKey();
            int required = entry.getValue();
            int available = sFreq.getOrDefault(ch, 0);

            minValue = Math.min(minValue, available / required);
        }

        return minValue;
    }
}
