class Solution {
    public int maxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE; // Initialize to the maximum possible value
        int maxProfit = 0; // Initialize maximum profit to 0

        for (int price : prices) { // Iterate through each price
            if (price < minValue) {
                minValue = price; // Update minValue if the current price is lower
            } else if (price - minValue > maxProfit) {
                maxProfit = price - minValue; // Calculate profit and update maxProfit
            }
        }

        return maxProfit; // Return the maximum profit found
    }
}
