class Solution {
    // Method to find the minimum difference between the max and min values in any subarray of k elements
    public int minimumDifference(int[] nums, int k) {
        // Sort the array in non-decreasing order
        Arrays.sort(nums);
      
        // Initialize the answer with a large value that is certain to be larger than any possible difference in the array
        int minDifference = Integer.MAX_VALUE;
      
        // Iterate through the array and consider each subarray of size k
        for (int i = 0; i < nums.length - k + 1; ++i) {
            // Calculate the difference between the last and the first element of the current subarray
            int currentDifference = nums[i + k - 1] - nums[i];
          
            // Update the minimum difference if the current difference is smaller
            minDifference = Math.min(minDifference, currentDifference);
        }
      
        // Return the minimum difference found
        return minDifference;
    }
}