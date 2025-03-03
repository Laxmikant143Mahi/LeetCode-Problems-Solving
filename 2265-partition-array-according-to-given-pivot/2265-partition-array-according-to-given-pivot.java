class Solution {
    // This method takes an array 'nums' and an integer 'pivot', then reorders the array such that
    // all elements less than 'pivot' come before elements equal to 'pivot', and those come before elements greater than 'pivot'.
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length; // Get the length of the array.
        int[] ans = new int[n]; // Create a new array 'ans' to store the reordered elements.
        int index = 0; // Initialize an index variable to keep track of the position in 'ans' array.
      
        // First pass: Place all elements less than 'pivot' into the 'ans' array.
        for (int num : nums) {
            if (num < pivot) {
                ans[index++] = num;
            }
        }
      
        // Second pass: Place all elements equal to 'pivot' into the 'ans' array.
        for (int num : nums) {
            if (num == pivot) {
                ans[index++] = num;
            }
        }
      
        // Third pass: Place all elements greater than 'pivot' into the 'ans' array.
        for (int num : nums) {
            if (num > pivot) {
                ans[index++] = num;
            }
        }
      
        return ans; // Return the reordered array.
    }
}
