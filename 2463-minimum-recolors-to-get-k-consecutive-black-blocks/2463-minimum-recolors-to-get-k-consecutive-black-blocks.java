class Solution {
    // Method to find the minimum number of recolors needed to get at least k consecutive black blocks
    public int minimumRecolors(String blocks, int k) {
        // Initialize the count of white blocks within the first window of size k
        int whiteCount = 0;
        for (int i = 0; i < k; ++i) {
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
        }

        // Initialize the answer with the count of white blocks within the first window
        int minRecolors = whiteCount;
      
        // Slide the window of size k across the string and update the minimum recolors requird
        for (int i = k; i < blocks.length(); ++i) {
            // If the entering character is white, increment white count
            if (blocks.charAt(i) == 'W') {
                whiteCount++;
            }
            // If the exiting character is white, decrement white count
            if (blocks.charAt(i - k) == 'W') {
                whiteCount--;
            }
            // Update the minimum recolors if the current count is less than the previous minimum
            minRecolors = Math.min(minRecolors, whiteCount);
        }

        // Return the minimum number of recolors required
        return minRecolors;
    }
}