class Solution {
    public long countSubarrays(int[] nums, long k) {
        long count = 0; // To store the number of subarrays
        long sum = 0; // Sum of the elements in the current subarray
        int start = 0; // Start index for the current subarray

        // Traverse through the array starting from the 0th element
        for (int end = 0; end < nums.length; ++end) {
            sum += nums[end]; // Add the current element to sum
          
            // Shrink the subarray from the left if the condition is violated
            // sum * length should be less than k
            while (sum * (end - start + 1) >= k) {
                sum -= nums[start]; // Removing the element from the start of subarray
                start++; // Increment the start index
            }
          
            // At this point, for each element nums[end], we find how many subarrays ending at 'end' are valid
            // The number of valid subarrays is given by the difference btw current end and the new start position
            count += end - start + 1;
        }
        return count; // Return the total count of valid subarrays
    }
}