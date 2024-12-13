class Solution {
    public int longestValidParentheses(String s) {
        int strLength = s.length();
        int[] validLengths = new int[strLength + 1]; // Array to store the length of valid parentheses substrings at each index.
        int maxValidLength = 0; // The maximum length of valid parentheses found.

        // Iterate starting from the second character as we need to check pairs.
        for (int i = 2; i <= strLength; ++i) {
            // Check if the current character is a closing parenthesis.
            if (s.charAt(i - 1) == ')') {
                // If the previous character is an opening parenthesis, it forms a valid pair.
                if (s.charAt(i - 2) == '(') {
                    validLengths[i] = validLengths[i - 2] + 2; // Add 2 for the valid '()' pair.
                } else {
                    // If the previous character is also a closing parenthesis,
                    // find the position before the valid substring that starts
                    // just before the current one.
                    int prevIndex = i - validLengths[i - 1] - 1;
                    // Check if there's a matching opening parenthesis.
                    if (prevIndex > 0 && s.charAt(prevIndex - 1) == '(') {
                        validLengths[i] = validLengths[i - 1] + 2 + validLengths[prevIndex - 1]; // Add lengths of valid substrings plus the new pair.
                    }
                }
                // Update the maximum length if needed.
                maxValidLength = Math.max(maxValidLength, validLengths[i]);
            }
        }

        return maxValidLength; // Return the maximum length of valid parentheses.
    }
}