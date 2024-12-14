class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;  // Not enough elements to form a triplet
        }

        int first = Integer.MAX_VALUE;  // First smallest element
        int second = Integer.MAX_VALUE; // Second smallest element

        for (int num : nums) {
            if (num <= first) {
                first = num;  // Update first to the smallest element
            } else if (num <= second) {
                second = num;  // Update second to the smallest element greater than first
            } else {
                // Found a number greater than both first and second, triplet exists
                return true;
            }
        }

        // If no triplet found
        return false;
    }
}
