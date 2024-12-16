import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Maximum product can either be:
        // 1. Product of the three largest numbers
        int option1 = nums[n-1] * nums[n-2] * nums[n-3];
        // 2. Product of the two smallest numbers (negative) and the largest number
        int option2 = nums[0] * nums[1] * nums[n-1];

        // Return the maximum of the two
        return Math.max(option1, option2);
    }
}
