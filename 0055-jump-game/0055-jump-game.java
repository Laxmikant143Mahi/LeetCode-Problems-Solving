class Solution {
    public boolean canJump(int[] nums) {
        int maxPos = 0; // Maximum position we can reach

        for (int i = 0; i < nums.length; i++) {
            // If the current index is greater than the maximum position reachable, return false
            if (i > maxPos) {
                return false;
            }
            // Update the maximum position reachable
            maxPos = Math.max(maxPos, nums[i] + i);
        }

        // If we exit the loop, it means we can reach or exceed the last index
        return true;
    }
}
