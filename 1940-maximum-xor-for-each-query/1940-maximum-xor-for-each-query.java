class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        // Initialize 'xorSum' to store the cumulative XOR of all elements in 'nums'.
        int xorSum = 0;
      
        // Calculate the cumulative XOR for all the elements in 'nums'.
        for (int num : nums) {
            xorSum ^= num;
        }
      
        // Calculate the mask by considering the maximum number of bits.
        // The mask will be a number with 'maximumBit' number of 1s in binary representation.
        int mask = (1 << maximumBit) - 1;
      
        // The length of the input array.
        int length = nums.length;
      
        // Initialize an array 'maximumXors' to hold the maximum XOR for each element in reverse order.
        int[] maximumXors = new int[length];
      
        // Iterate over the 'nums' array in reverse, computing the maximum XOR for each prefix.
        for (int i = 0; i < length; ++i) {
            // XOR the current cumulative sum with the mask to find the maximum XOR value.
            int maxXor = xorSum ^ mask;
          
            // Add the maximum XOR value to the result array.
            maximumXors[i] = maxXor;
          
            // Update the 'xorSum' to remove the contribution of the current element because
            // we are moving from the end of the array towards the start.
            int currentNum = nums[length - i - 1];
            xorSum ^= currentNum;
        }
      
        // Return the array of maximum XOR values.
        return maximumXors;
    }
}
