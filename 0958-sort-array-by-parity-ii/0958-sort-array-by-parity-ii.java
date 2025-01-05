class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0; // Pointer for even index
        int j = 1; // Pointer for odd index
        int n = nums.length;

        while (i < n && j < n) {
            // If i points to an even index but contains an odd number
            if (i % 2 == 0 && nums[i] % 2 != 0) {
                // Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            // If j points to an odd index but contains an even number
            if (j % 2 == 1 && nums[j] % 2 != 1) {
                // Swap nums[j] and nums[i]
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }

            // Move pointers to the next positions
            if (nums[i] % 2 == 0) {
                i += 2; // Move to the next even index
            }
            if (nums[j] % 2 == 1) {
                j += 2; // Move to the next odd index
            }
        }

        return nums;
    }
}
