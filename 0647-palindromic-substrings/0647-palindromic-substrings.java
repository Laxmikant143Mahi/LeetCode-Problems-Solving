class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int count = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            count++;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                count++;
            }
        }

        // Check for substrings of length 3 or more
        for (int len = 3; len <= n; len++) { // Lengths should go up to n
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index of the substring
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                    count++;
                }
            }
        }

        return count;
    }
}
