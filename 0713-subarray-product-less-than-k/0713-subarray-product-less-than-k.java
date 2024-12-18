class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // If k is less than or equal to 1, no subarray can have a product strictly less than k.
        if (k <= 1) return 0;

        int product = 1;  // Variable to track the product of the current subarray
        int left = 0;     // Left pointer of the sliding window
        int result = 0;   // Variable to count the number of valid subarrays

        // Iterate through the array with the right pointer
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];  // Include nums[right] in the product
            
            // Shrink the window from the left until the product is less than k
            while (product >= k && left <= right) {
                product /= nums[left];  // Remove nums[left] from the product
                left++;                 // Move the left pointer to the right
            }

            // All subarrays ending at `right` and starting from any index between `left` and `right`
            // are valid. Add their count to the result.
            result += (right - left + 1);
        }

        return result;  // Return the total number of valid subarrays
    }
}
