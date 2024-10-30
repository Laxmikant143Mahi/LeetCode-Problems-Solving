class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int length = nums.length;

        // Arrays to store the longest increasing subsequence ending at each index from the left and right
        int[] longestIncreasingLeft = new int[length];
        int[] longestIncreasingRight = new int[length];

        // Initialize the arrays with a default value of 1
        Arrays.fill(longestIncreasingLeft, 1);
        Arrays.fill(longestIncreasingRight, 1);

        // Calculate the longest increasing subsequence for each index from the left
        for (int i = 1; i < length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    longestIncreasingLeft[i] = Math.max(longestIncreasingLeft[i], longestIncreasingLeft[j] + 1);
                }
            }
        }

        // Calculate the longest increasing subsequence for each index from the right
        for (int i = length - 2; i >= 0; --i) {
            for (int j = i + 1; j < length; ++j) {
                if (nums[i] > nums[j]) {
                    longestIncreasingRight[i] = Math.max(longestIncreasingRight[i], longestIncreasingRight[j] + 1);
                }
            }
        }

        int maxMountainSize = 0;
        // Find the maximum size of a valid mountain subsequence
        for (int i = 0; i < length; ++i) {
            // To form a mountain, the element nums[i] must be increasing and decreasing, both sides at least by 1 element
            if (longestIncreasingLeft[i] > 1 && longestIncreasingRight[i] > 1) {
                // Calculate the length of the mountain and update the maximum mountain size
                int mountainSize = longestIncreasingLeft[i] + longestIncreasingRight[i] - 1;
                maxMountainSize = Math.max(maxMountainSize, mountainSize);
            }
        }

        // The minimum removals is the array length minus the maximum mountain size
        return length - maxMountainSize;
    }
}
