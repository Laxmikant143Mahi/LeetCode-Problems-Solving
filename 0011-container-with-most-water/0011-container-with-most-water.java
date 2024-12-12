class Solution {
    public int maxArea(int[] height) {
        int start = 0; // Pointer to the first line
        int end = height.length - 1; // Pointer to the last line
        int maxWater = 0; // Variable to store the maximum area

        // Loop until the two pointers meet
        while (start < end) {
            // Calculate the area between the two lines
            int currentWater = Math.min(height[start], height[end]) * (end - start);
            // Update maxWater if the current area is larger
            maxWater = Math.max(maxWater, currentWater);

            // Move the pointer corresponding to the shorter line
            if (height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }

        return maxWater;
    }
}
