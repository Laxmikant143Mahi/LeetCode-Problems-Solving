
public class Solution {
  
    // Function to maximize sum of min(ai, bi) for all pairs (ai, bi)
    public int arrayPairSum(int[] nums) {
        // Sort the array to make pairs of two consecutive elements
        Arrays.sort(nums);

        // Initialize sum to store the final answer
        int sum = 0;

        // Iterate through the array, jumping two steps at a time
        for (int i = 0; i < nums.length; i += 2) {
            // Add the first element of each pair to the sum since it's the minimum
            sum += nums[i];
        }

        // Return the accumulated sum of the min elements of the pairs
        return sum;
    }
}
