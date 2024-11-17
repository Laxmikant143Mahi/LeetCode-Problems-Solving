class Solution {
  
    // Function to find the length of the shortest subarray with a sum at least 'k'
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length; // Get the length of the input array
        long[] prefixSums = new long[n + 1]; // Create an array to store prefix sums
      
        // Calculate prefix sums
        for (int i = 0; i < n; ++i) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }
      
        // Initialize a deque to keep track of indices
        Deque<Integer> indexDeque = new ArrayDeque<>();
        int minLength = n + 1; // Initialize the minimum length to an impossible value (larger than the array itself)
      
        // Iterate over the prefix sums
        for (int i = 0; i <= n; ++i) {
          
            // While the deque is not empty, check if the current sum minus the front value is >= k
            while (!indexDeque.isEmpty() && prefixSums[i] - prefixSums[indexDeque.peek()] >= k) {
                minLength = Math.min(minLength, i - indexDeque.poll()); // If true, update minLength
            }
          
            // While the deque is not empty, remove all indices from the back that have a prefix sum greater than or equal to the current sum
            while (!indexDeque.isEmpty() && prefixSums[indexDeque.peekLast()] >= prefixSums[i]) {
                indexDeque.pollLast();
            }
          
            // Add the current index to the deque
            indexDeque.offer(i);
        }
      
        // If minLength is still greater than the length of the array, there is no valid subarray, return -1
        return minLength > n ? -1 : minLength;
    }
}
