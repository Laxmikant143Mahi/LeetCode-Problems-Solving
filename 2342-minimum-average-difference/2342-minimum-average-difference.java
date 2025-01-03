class Solution {
    public int minimumAverageDifference(int[] nums) {
        // Get the length of the input array
        int arrayLength = nums.length;
        // Initialize prefix sum and suffix sum variables
        long prefixSum = 0, suffixSum = 0;

        // Calculate the total sum of the array elements (suffixSum)
        for (int number : nums) {
            suffixSum += number;
        }

        // Initialize the variable to store the index of the result
        int resultIndex = 0;
        // Initialize the minimum difference variable with the maximum value possible
        long minimumDifference = Long.MAX_VALUE;

        // Iterate through the array to calculate prefix and suffix sums dynamically
        for (int i = 0; i < arrayLength; ++i) {
            // Add the current number to the prefix sum
            prefixSum += nums[i];
            // Subtract the current number from the suffix sum
            suffixSum -= nums[i];
          
            // Calculate the average of the prefix part
            long prefixAvg = prefixSum / (i + 1);
            // Calculate the average of the suffix part, or set to 0 if there are no elements remaining
            long suffixAvg = arrayLength - i - 1 == 0 ? 0 : suffixSum / (arrayLength - i - 1);
            // Calculate the absolute difference between the two averages
            long currentDifference = Math.abs(prefixAvg - suffixAvg);

            // If the current difference is less than the minimum found so far, update the result and minimum
            if (currentDifference < minimumDifference) {
                resultIndex = i;
                minimumDifference = currentDifference;
            }
        }
        // Return the index where the absolute difference between the averages is minimum
        return resultIndex;
    }
}