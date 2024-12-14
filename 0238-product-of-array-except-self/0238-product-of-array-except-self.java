class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Step 1: Initialize the length of the input array
        int n = nums.length;

        // Step 2: Create two arrays to store prefix and suffix products
        int pref[] = new int[n];  // Array to store prefix products
        int suff[] = new int[n];  // Array to store suffix products

        // Step 3: Calculate prefix products
        // pref[i] will store the product of all elements from nums[0] to nums[i]
        pref[0] = nums[0];  // The prefix product for the first element is the element itself
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] * nums[i];  // Multiply current element with the previous prefix product
        }
        
        // Step 4: Calculate suffix products
        // suff[i] will store the product of all elements from nums[i] to nums[n-1]
        suff[n - 1] = nums[n - 1];  // The suffix product for the last element is the element itself
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i];  // Multiply current element with the next suffix product
        }
        
        // Step 5: Create the result array to store the final output
        int result[] = new int[n];

        // Step 6: Calculate the final result by multiplying the corresponding prefix and suffix products
        // The first element's result is the suffix product starting from the second element
        result[0] = suff[1];  
        
        // Step 7: For the middle elements, the result will be the product of the corresponding prefix and suffix products
        for (int i = 1; i < n - 1; i++) {
            result[i] = pref[i - 1] * suff[i + 1];  // Multiply the previous prefix product with the next suffix product
        }
        
        // Step 8: The last element's result is the prefix product of the second-to-last element
        result[n - 1] = pref[n - 2];

        // Step 9: Return the final result array
        return result;
    }
}
