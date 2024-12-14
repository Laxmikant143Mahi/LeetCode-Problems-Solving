class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        
        // Prefix sum array initialization
        int[] pref = new int[n];
        pref[0] = nums[0];

        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
        }

        // Initialize maxSum as the sum of the first 'k' elements
        double maxSum = (double) (pref[k - 1]) / k;

        // Iterate over the rest of the array, checking each subarray of size 'k'
        for (int i = k; i < n; i++) {
            // Calculate sum of the subarray from index (i-k+1) to i
            double currentSum = (double) (pref[i] - pref[i - k]) / k;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
