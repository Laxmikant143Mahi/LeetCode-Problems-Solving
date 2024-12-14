import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        
        // Step 1: Count the occurrences of each element using a HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        // Step 2: Use a HashSet to track unique occurrence counts
        HashSet<Integer> set = new HashSet<>();
        for (int count : map.values()) {
            // If an occurrence count is already in the set, return false
            if (!set.add(count)) {
                return false;
            }
        }
        
        // Step 3: If all occurrence counts are unique, return true
        return true;
    }
}
