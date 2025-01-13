class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxOnes = 0;
        int zeroCount = 0; 

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If we have exceeded the allowed number of zeros, 
            // move the left pointer to maintain the window's zero count
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxOnes = Math.max(maxOnes, right - left + 1);
            right++;
        }

        return maxOnes;
    }
}