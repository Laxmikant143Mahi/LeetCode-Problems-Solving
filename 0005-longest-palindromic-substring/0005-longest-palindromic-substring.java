class Solution {
    public String longestPalindrome(String S) {
          int n = S.length();
        int[][] dp = new int[n][n]; // DP table to store if S[i..j] is a palindrome

        int start = 0; // Starting index of the longest palindrome
        int maxLength = 1; // Length of the longest palindrome

        // Step 1: All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Step 2: Check substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                if (maxLength < 2) { // Update if a longer palindrome is found
                    start = i;
                    maxLength = 2;
                }
            }
        }

        // Step 3: Check substrings of length 3 or more
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1; // Ending index of the substring

                // Check if S[i..j] is a palindrome
                if (S.charAt(i) == S.charAt(j) && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;

                    // Update longest palindrome if current length is greater
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        // Return the longest palindromic substring
        return S.substring(start, start + maxLength);
    }
}