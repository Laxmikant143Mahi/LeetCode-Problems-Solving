class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        // Hash map to store the cumulative sum up to the current index with the index itself
        Map<Integer, Integer> cumSumToIndex = new HashMap<>();
        cumSumToIndex.put(0, 0); // Initialization with sum 0 at index 0

        int n = arr.length; // Length of the array
        int[] minLengths = new int[n + 1]; // Array to store the minimum subarray length ending at i that sums up to target
        final int infinity = 1 << 30; // A very large number treated as infinity
        minLengths[0] = infinity; // Initialize with infinity since there's no subarray ending at index 0

        int currentSum = 0; // Sum of the current subarray
        int answer = infinity; // Initialize the answer with a large number representing infinity

        // Loop through the array to find minimum subarrays
        for (int i = 1; i <= n; ++i) {
            int value = arr[i - 1]; // Value at current index in the array
            currentSum += value; // Update the current sum
          
            // Copy the minimum subarray length found so far to current position
            minLengths[i] = minLengths[i - 1];
          
            // If the (currentSum - target) is found before, update the minimum length and answer
            if (cumSumToIndex.containsKey(currentSum - target)) {
                int j = cumSumToIndex.get(currentSum - target); // Previous index where the cumulative sum was currentSum - target
                minLengths[i] = Math.min(minLengths[i], i - j); // Update the minimum length for current index
                answer = Math.min(answer, minLengths[j] + i - j); // Calculate the combined length and update the answer
            }
          
            // Store the current cumulative sum and corresponding index
            cumSumToIndex.put(currentSum, i);
        }
      
        // If the answer is still infinity, no such subarrays are found; return -1. Else, return the found answer
        return answer > n ? -1 : answer;
    }
}
