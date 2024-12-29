class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        // Step 1: Compute prefix sum for efficient range sum calculations
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + stoneValue[i];
        }

        // Step 2: DP array to store maximum score Alice can achieve
        int[][] dp = new int[n][n];

        // Step 3: Fill the DP table
        for (int length = 2; length <= n; length++) { // Length of the current range
            for (int i = 0; i <= n - length; i++) { // Start of the range
                int j = i + length - 1; // End of the range
                for (int k = i; k < j; k++) { // Split point
                    int leftSum = prefixSum[k + 1] - prefixSum[i];
                    int rightSum = prefixSum[j + 1] - prefixSum[k + 1];

                    if (leftSum < rightSum) {
                        dp[i][j] = Math.max(dp[i][j], leftSum + dp[i][k]);
                    } else if (leftSum > rightSum) {
                        dp[i][j] = Math.max(dp[i][j], rightSum + dp[k + 1][j]);
                    } else { // Both parts are equal
                        dp[i][j] = Math.max(dp[i][j], leftSum + Math.max(dp[i][k], dp[k + 1][j]));
                    }
                }
            }
        }

        // Step 4: The result is stored in dp[0][n-1] (entire range)
        return dp[0][n - 1];
    }
}
