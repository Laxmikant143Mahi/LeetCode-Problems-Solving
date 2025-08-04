class Solution {
    public int maxProfit(int[] prices) {
        
        int maxProfit = 0;
        int minSoFar = Integer.MAX_VALUE;
        int profit = 0;

        for(int i=0; i<prices.length; i++){

            minSoFar = Math.min(minSoFar,prices[i]);

            profit = prices[i]-minSoFar;

            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }
}