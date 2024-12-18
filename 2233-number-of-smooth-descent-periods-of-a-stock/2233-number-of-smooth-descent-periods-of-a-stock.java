class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;
        long total = 1; // Each element itself is a descent period
        long currentDescentLength = 1; // Length of the current descent period
        
        for (int i = 1; i < n; i++) {
            // Check if the current price continues the descent
            if (prices[i] == prices[i - 1] - 1) {
                currentDescentLength++;
            } else {
                currentDescentLength = 1; // Reset for a new descent period
            }
            total += currentDescentLength; // Add the length to the total
        }
        
        return total;
    }
}
