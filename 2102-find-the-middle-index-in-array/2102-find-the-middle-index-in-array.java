class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        int runningSum = 0;

        // Calculate total sum of the array
        for (int num : nums) {
            totalSum += num;
        }

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Check if the left sum equals the right sum
            if (runningSum == totalSum - runningSum - nums[i]) {
                return i;
            }
            // Update the running sum (left sum)
            runningSum += nums[i];
        }

        return -1; // No middle index found
    }
}
