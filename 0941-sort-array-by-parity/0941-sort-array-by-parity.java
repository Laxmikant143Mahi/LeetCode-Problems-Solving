class Solution {

    // This function takes an integer array 'nums' and returns an array
    // with all even integers followed by all odd integers.
    public int[] sortArrayByParity(int[] nums) {
        // Initialize two pointers: 'left' starting from the beginning and 'right' from the end of the array.
        int left = 0, right = nums.length - 1;

        // Continue until 'left' pointer is less than 'right' pointer.
        while (left < right) {
            // If the element at 'left' index is odd, swap it with the element at 'right' index.
            if (nums[left] % 2 == 1) {
                // Perform the swap of elements.
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
              
                // Decrement 'right' pointer as we have moved an odd number to the correct side of array.
                right--;
            } else {
                // Increment 'left' pointer if the current element is even,
                // as it is already in the correct side of array.
                left++;
            }
        }
        // Return the rearranged array with all even numbers first followed by odd numbers.
        return nums;
    }
}