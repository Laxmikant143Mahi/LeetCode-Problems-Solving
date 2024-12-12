class Solution {
    public int trap(int[] height) {
        int n = height.length; // Length of the input array
        int maxRight = 0, maxLeft = 0; // Variables to store the maximum heights seen so far from left and right
        int left = 0, right = n - 1; // Two pointers, one starting from the left and the other from the right
        int ans = 0; // Variable to store the total amount of trapped water

        // While the two pointers do not cross each other
        while (left < right) {
            // If the height at the left pointer is less than or equal to the height at the right pointer
            if (height[left] <= height[right]) {
                // Update the maximum height on the left
                maxLeft = Math.max(maxLeft, height[left]);
                // Add the water trapped at this index to the total
                ans += maxLeft - height[left];
                // Move the left pointer to the right
                left++;
            } else {
                // If the height at the right pointer is less than the height at the left pointer
                // Update the maximum height on the right
                maxRight = Math.max(maxRight, height[right]);
                // Add the water trapped at this index to the total
                ans += maxRight - height[right];
                // Move the right pointer to the left
                right--;
            }
        }

        return ans; // Return the total trapped water
    }
}
