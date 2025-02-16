class Solution {
    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > threshold || nums[i] % 2 != 0) continue; // Start with an even number within threshold

            int j = i;
            while (j < n && nums[j] <= threshold && (j == i || nums[j] % 2 != nums[j - 1] % 2)) {
                j++; // Expand subarray
            }

            maxLen = Math.max(maxLen, j - i);
        }

        return maxLen;
    }
}
