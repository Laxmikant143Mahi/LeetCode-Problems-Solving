class Solution {
  
    // Function to find the maximum length of a contiguous subarray with equal number of 0s and 1s.
    public int findMaxLength(int[] nums) {
        // Create a hash map to store the sum so far (key) and its index (value).
        Map<Integer, Integer> sumToIndexMap = new HashMap<>();
      
        // Initialize the sum of elements to 0 and the answer to the max length to 0.
        sumToIndexMap.put(0, -1); // Sum of 0 is considered to appear before the array starts.
        int sum = 0, maxLength = 0;

        // Iterate through the array.
        for (int i = 0; i < nums.length; i++) {
            // Update sum: +1 for '1', -1 for '0'. This helps in finding equal numbers of 1s and 0s.
            sum += nums[i] == 1 ? 1 : -1;

            // If the sum has been seen before, it means the subarray between the two indices has
            // equal number of 0s and 1s.
            if (sumToIndexMap.containsKey(sum)) {
                // Update maxLength with the larger value between current maxLength and the distance
                // between current index and the first index where this sum appeared.
                maxLength = Math.max(maxLength, i - sumToIndexMap.get(sum));
            } else {
                // If sum is not found in the map, add it with its index.
                sumToIndexMap.put(sum, i);
            }
        }
      
        // Return the found maximum length.
        return maxLength;
    }
}
