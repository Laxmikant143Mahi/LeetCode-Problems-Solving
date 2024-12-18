class Solution {

    /**
     * Determines the sign of the product of an array of numbers.
     * The result is 1 if the product is positive, -1 if negative, and 0 if any number is 0.
     *
     * @param nums the array of integers
     * @return the sign of the product of the input array
     */
    public int arraySign(int[] nums) {
        // Initialize the sign as positive (1)
        int productSign = 1;

        // Iterate over each value in the array
        for (int value : nums) {
            // If any number is zero, the product is zero, so return 0
            if (value == 0) {
                return 0;
            }
            // If the number is negative, flip the current sign
            if (value < 0) {
                productSign *= -1;
            }
        }
      
        // Return the sign of the product
        return productSign;
    }
}