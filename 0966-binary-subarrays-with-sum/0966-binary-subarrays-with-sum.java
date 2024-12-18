class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0; // To store the total count of valid subarrays
        int prefixSum = 0; // Current prefix sum
        Map<Integer, Integer> prefixMap = new HashMap<>(); // To store the frequency of prefix sums
        
        prefixMap.put(0, 1); // Base case: A prefix sum of 0 occurs once
        
        for (int num : nums) {
            prefixSum += num; // Update the prefix sum
            
            // Check if (prefixSum - goal) exists in the map
            if (prefixMap.containsKey(prefixSum - goal)) {
                count += prefixMap.get(prefixSum - goal); // Add its frequency to the count
            }
            
            // Update the map with the current prefix sum
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }
        
        return count;
    }
}
