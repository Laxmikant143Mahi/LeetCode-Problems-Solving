class Solution {
    public int longestDecomposition(String text) {
        int n = text.length();
        Integer[][] dp = new Integer[n][n];  // memoization table
        return helper(text, 0, n - 1, dp);
    }

    private int helper(String text, int left, int right, Integer[][] dp) {
        // Base Case: if left > right, no characters left
        if (left > right) return 0;
        // If left == right, single char chunk
        if (left == right) return 1;
        // Already computed
        if (dp[left][right] != null) return dp[left][right];

        int n = text.length();
        int maxChunks = 1;  // Minimum is 1 chunk (the whole substring)

        // Try matching from both ends
        for (int len = 1; left + len - 1 < right - len + 1; len++) {
            String prefix = text.substring(left, left + len);
            String suffix = text.substring(right - len + 1, right + 1);

            // When prefix equals suffix, it's a valid mirror split
            if (prefix.equals(suffix)) {
                int inside = helper(text, left + len, right - len, dp);
                maxChunks = Math.max(maxChunks, 2 + inside);
            }
        }

        return dp[left][right] = maxChunks;
    }
}
