class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int i = 0; // Pointer for even index
        int j = 1; // Pointer for odd index
        int n = nums.length;

        while (i < n && j < n) {
            if (nums[i] % 2 == 0) {
                i += 2; // Correct position for even index
            } else if (nums[j] % 2 == 1) {
                j += 2; // Correct position for odd index
            } else {
                // Swap if nums[i] is odd and nums[j] is even
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i += 2;
                j += 2;
            }
        }
        return nums;
    }
}
